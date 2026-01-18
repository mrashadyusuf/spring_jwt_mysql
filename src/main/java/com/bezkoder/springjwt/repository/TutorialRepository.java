package com.bezkoder.springjwt.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import  com.bezkoder.springjwt.models.Tutorial;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);
    Page<Tutorial> findByTitleContaining(String title, Pageable pageable);
}