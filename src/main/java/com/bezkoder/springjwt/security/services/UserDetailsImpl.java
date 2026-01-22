package com.bezkoder.springjwt.security.services;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bezkoder.springjwt.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    // username adalah PRIMARY KEY
    private String username;

    private String email;

    @JsonIgnore
    private String password;

    // karena entity User tidak punya role,
    // kita set authorities kosong
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(
            String username,
            String email,
            String password,
            Collection<? extends GrantedAuthority> authorities) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    // Factory method untuk konversi User → UserDetails
    public static UserDetailsImpl build(User user) {

        return new UserDetailsImpl(
                user.getUsername(),     // 👈 PK
                user.getEmail(),
                user.getPassword(),
                Collections.emptyList() // 👈 tidak ada role
        );
    }

    /* =====================
       Implement UserDetails
       ===================== */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    // ⚠️ INI KRUSIAL
    // Spring Security menganggap ini IDENTITAS USER
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /* =====================
       Tambahan (opsional)
       ===================== */

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDetailsImpl)) return false;
        UserDetailsImpl that = (UserDetailsImpl) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
