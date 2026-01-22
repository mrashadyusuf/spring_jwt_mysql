package com.bezkoder.springjwt.payload.response;

import java.util.List;

public class JwtResponse {

    private String token;
    private String type = "Bearer";

    // username adalah PRIMARY KEY & identitas user
    private String username;

    private String email;

    private List<String> roles;

    public JwtResponse(String token,
                       String username,
                       String email,
                       List<String> roles) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    /* =====================
       Getter & Setter
       ===================== */

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }
}
