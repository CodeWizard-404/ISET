package com.WS1.ProjectManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WS1.ProjectManagement.Entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
