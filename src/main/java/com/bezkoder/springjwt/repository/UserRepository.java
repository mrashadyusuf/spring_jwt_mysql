package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.Tutorial;
import com.bezkoder.springjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
    
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Page<User> findByUsernameOrNameOrEmail(
        String username,
        String name,
        String email,
        Pageable pageable
    );


    
}
