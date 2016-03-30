package com.brainbox.school.dto;

/**
 * Created by adityaagrawal on 31/03/16.
 */
public class LoginDTO {
    private String email;
    private String password;
    private String scope;

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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
