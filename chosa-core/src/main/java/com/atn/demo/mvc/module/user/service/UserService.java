package com.atn.demo.mvc.module.user.service;



import org.springframework.web.multipart.MultipartFile;

import com.atn.commons.service.MyService;
import com.atn.demo.mvc.module.TrainingCenterMember.entity.TrainingCenterMember;
import com.atn.demo.mvc.module.country.entity.Country;
import com.atn.demo.mvc.module.user.entity.Role;
import com.atn.demo.mvc.module.user.entity.Role.ROLE;
import com.atn.demo.mvc.module.user.entity.User;

public interface UserService extends MyService<User,Long> {
	public User findByEmail(String email);
	public String getMessage();
	public User getConnectedUser();
	public String getAdminMessage();
	public User findByGoogleId(String id);
	public User inscription(User user, MultipartFile picture,String prefix);
	public User cryptPassword(User user);
	public User addRoleUser(User user, ROLE name);
	public Role createRole(User user, ROLE name);
	public User findByFacebookId(String id);
	public User inscriptionUserTeacher(User user, MultipartFile picture,TrainingCenterMember teacher);
	public User update(Long userId,String userEmail, String userName, String firstName, String lastName, String userAdress,
			String userPhone, String userStatus, Country userCountry);
	public  User updateProfil(User user);
	public User validateAccountUser(String email);

}
