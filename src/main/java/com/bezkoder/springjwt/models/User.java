package com.bezkoder.springjwt.models;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    
    // @ManyToMany(fetch = FetchType.LAZY)
    // @JoinTable(  name = "user_roles", 
    //         joinColumns = @JoinColumn(name = "user_id"), 
    //         inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Transient // 👈 JPA: abaikan field ini
    private Set<Role> roles = new HashSet<>();

    public User(String username, String name,String email, String password) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public User() {
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    } 

    @Id
    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /* =====================
       Lifecycle Callbacks
       ===================== */
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    /* =====================
       Getter & Setter
       ===================== */

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    
    // jangan expose password ke response
    public void setPassword(String password) {
        this.password = password;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
