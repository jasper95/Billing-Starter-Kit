package com.jasperprojects.starter.service.dto;

import com.jasperprojects.starter.domain.Role;
import com.jasperprojects.starter.domain.User;
import com.jasperprojects.starter.domain.enums.UserStatus;
import com.jasperprojects.starter.domain.enums.UserType;

import java.util.Set;
import java.util.stream.Collectors;


public class UserDTO extends AuditableEntityDTO {

    private Long id;

    private String fullName;

    private String username;

    private UserStatus status;

    private UserType type;

    private Set<String> roles;

    public UserDTO(User user){
        super(user);
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.status = user.getStatus();
        this.type = user.getType();
        this.roles = user.getRoles().stream()
                                    .map(Role::getRoleName)
                                    .collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", roles=" + roles +
                '}';
    }

}
