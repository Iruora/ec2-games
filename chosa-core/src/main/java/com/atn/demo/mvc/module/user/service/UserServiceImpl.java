package com.atn.demo.mvc.module.user.service;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.atn.commons.persistence.BaseDao;
import com.atn.commons.service.MyAbstractService;
import com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember;
import com.atn.demo.mvc.module.TrainingCenterMember.service.TrainingCenterMemberService;
import com.atn.demo.mvc.module.country.entity.Country;
import com.atn.demo.mvc.module.file.entity.File;
import com.atn.demo.mvc.module.file.service.FileService;
import com.atn.demo.mvc.module.templateMail.entity.TemplateMail;
import com.atn.demo.mvc.module.templateMail.service.TemplateMailService;
import com.atn.demo.mvc.module.user.dao.UserDao;
import com.atn.demo.mvc.module.user.entity.Role;
import com.atn.demo.mvc.module.user.entity.Role.ROLE;
import com.atn.demo.mvc.module.user.entity.User;
import com.atn.demo.mvc.module.user.entity.User.STATUS;

@Component
public class UserServiceImpl extends MyAbstractService<User, Long> implements UserService, UserDetailsService {

	@Autowired
	RoleService roleService;

	@Autowired
	TrainingCenterMemberService trainingCenterMemberService;

	@Autowired
	FileService fileService;
	@Autowired
	TemplateMailService emailService;

	public UserServiceImpl(UserDao dataAccessObject) {
		super(dataAccessObject);
	}

	@Override
	public BaseDao<User, Long> getDataAccessObject() {
		return this.dataAccessObject;
	}

	@Override
	public User findByEmail(String email) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("=userEmail", email);
		List<User> result = findListByCriteria(map, 1, 0, BaseDao.DELETION_STATUS.ACTIVE);
		if (!result.isEmpty())
			return result.get(0);
		else
			return null;
	}

	@PreAuthorize("authenticated")
	public String getMessage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return "Hello " + authentication;
	}

	@PreAuthorize("authenticated")
	public User getConnectedUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetails = ((UserDetails) authentication.getPrincipal());
			User user = findByEmail(userDetails.getUsername());
			return user;
		}
		return null;
	}

	@PreAuthorize("hasRole('ADMIN')")
	public String getAdminMessage() {
		return " I am Admin";
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("L'adresse email '" + username + "' est introuvale ou désactivé !!!");
		}
		String password = user.getUserPassword();
		boolean enabled = user.getDeletingDate() == null;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		Collection<? extends GrantedAuthority> authorities = user.getRoles();
		org.springframework.security.core.userdetails.User connectedUser = new org.springframework.security.core.userdetails.User(
				username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		return connectedUser;
	}

	@Override
	public User findByGoogleId(String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("=googleId", id);
		map.put("=status", STATUS.VALIDATE);
		List<User> users = findListByCriteria(map, null, 0, BaseDao.DELETION_STATUS.ACTIVE);
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public User findByFacebookId(String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("=facebookId", id);
		map.put("=status", STATUS.VALIDATE);
		List<User> users = findListByCriteria(map, null, 0, BaseDao.DELETION_STATUS.ACTIVE);
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	@Override
	@Transactional
	public User inscription(User user, MultipartFile picture, String prefix) {

		user.setStatus(STATUS.SIGNUP);
		user = save(user);

		if ((picture != null) && (picture.getSize() > 0)) {

			File pictureFile = fileService.saveFile(picture, user.getId(), user.getUserName());
			user.setPicture(pictureFile);

		}
		user = addRoleUser(user, Role.ROLE.USER);
		user = cryptPassword(user);
		if ((user.getFacebookId() != null || user.getGoogleId() != null)
				&& (!user.getFacebookId().isEmpty() || !user.getGoogleId().isEmpty())) {
			user.setStatus(STATUS.VALIDATE);
			emailService.sendHtmlMail(user, TemplateMail.EMAIL_TEMPLATE.EmailConfirmation);
		} else {
			user.setStatus(STATUS.SIGNUP);
			emailService.sendHtmlMail(user, TemplateMail.EMAIL_TEMPLATE.EmailConfirmation);
		}
		return save(user);
	}

	@Override
	@Transactional
	public User cryptPassword(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String crypt = passwordEncoder.encode(user.getUserPassword());
		user.setUserPassword(crypt);
		return save(user);
	}

	@Override
	@Transactional
	public User addRoleUser(User user, ROLE name) {
		Set<Role> roles = new HashSet<>();
		if (user.getRoles() != null) {
			roles = user.getRoles();
		}
		Role role = createRole(user, name);
		roles.add(role);
		user.setRoles(roles);

		return save(user);
	}

	@Override
	public Role createRole(User user, ROLE name) {
		Role role = new Role();
		role.setUser(user);
		role.setRole(name);
		role.setCreationDate(new Date());
		role.setUpdatingDate(new Date());

		return roleService.save(role);
	}

	@Override
	@Transactional
	public User update(Long userId, String userEmail, String userName, String firstName, String lastName,
			String userAdress, String userPhone, String userStatus, Country userCountry) {
		User updateUser = findById(userId);
		if (updateUser != null) {
			updateUser.setStatus(User.STATUS.valueOf(userStatus));
			updateUser.setUserId(updateUser.getId());
			updateUser.setUserName(userName);
			updateUser.setFirstName(firstName);
			updateUser.setLastName(lastName);
			updateUser.setAdress(userAdress);
			updateUser.setPhone(userPhone);
			updateUser.setUserEmail(userEmail);
			updateUser.setCountry(userCountry);
			return save(updateUser);
		}
		return updateUser;
	}

	@Override
	@Transactional
	public User inscriptionUserTeacher(User user, MultipartFile picture, TrainingCenterMember teacher) {
		user.setStatus(STATUS.SIGNUP);
		user = save(user);
		if ((picture != null) && (picture.getSize() > 0)) {
			// Document document = documentService.saveFile(picture,
			// user.getId(), user.getUsername());
			// user.setPicture(document);
		}
		user = addRoleUser(user, Role.ROLE.USER);
		user = cryptPassword(user);
		if ((user.getFacebookId() != null) || (user.getGoogleId() != null)) {
			user.setStatus(STATUS.VALIDATE);
		} else {
			user.setStatus(STATUS.SIGNUP);

		}
		User userSave = save(user);
		teacher.setMember(userSave);
		trainingCenterMemberService.save(teacher);

		return userSave;
	}

	@Override
	@Transactional
	public User updateProfil(User user) {
		User updateUser = findById(user.getUserId());
		if (updateUser != null) {
			updateUser.setUserId(user.getUserId());
			updateUser.setUserName(user.getUserName());
			updateUser.setFirstName(user.getFirstName());
			updateUser.setLastName(user.getLastName());
			updateUser.setAdress(user.getAdress());
			updateUser.setPhone(user.getPhone());
			updateUser.setUserEmail(user.getUserEmail());
			updateUser.setCountry(user.getCountry());
			return save(updateUser);
		}
		return updateUser;
	}
	@Override
	@Transactional
	public User validateAccountUser(String email) {
		User user = findByEmail(email);
		user.setStatus(STATUS.VALIDATE);
		user = save(user);
		return user;
	}
}
