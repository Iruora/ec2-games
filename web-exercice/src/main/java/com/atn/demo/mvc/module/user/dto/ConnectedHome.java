package com.atn.demo.mvc.module.user.dto;

import com.atn.demo.mvc.module.user.entity.Role;
import com.atn.demo.mvc.module.user.entity.User;

import java.util.Iterator;

public class ConnectedHome {
    String fullName;
    String roleName;
    String title;
    public void setUser(User user){
        setFullName(user.getUserEmail());
        String roleName = "NoRole";
        Iterator<Role> roles = user.getRoles().iterator();
        while(roles.hasNext()){
            roleName = roles.next().getRole().name();
        }
        setRoleName(roleName);
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
