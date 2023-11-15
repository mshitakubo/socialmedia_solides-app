package com.socialmediasolides.usersrv.models.dtos;

import javax.validation.constraints.Email;
import java.util.List;

public class UserDto {

    private Long id;
    private String name;
    @Email
    private String email;
    private String password;
    private List<RolesDto> roles;

    public List<RolesDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesDto> roles) {
        this.roles = roles;
    }


    public UserDto() {

    }

    public UserDto(Long id, String name, String email, String password, List<RolesDto> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
