package com.example.tour.project;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findProjectById(Long id);
}
