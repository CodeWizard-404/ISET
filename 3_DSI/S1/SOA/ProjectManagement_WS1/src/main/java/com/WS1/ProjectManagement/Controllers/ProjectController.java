package com.WS1.ProjectManagement.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WS1.ProjectManagement.Entities.Project;
import com.WS1.ProjectManagement.services.ProjectService;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    //@Autowired
    //private ProjectService projectService;

    //@GetMapping
    //public List<Project> getAllProjects() {
    //    return projectService.getAllProjects();
    //}
    //@GetMapping("/{id}")
    //public Response getProjectById(@PathParam("id") Long id) {
    //    Project project = projectService.getProjectById(id);
    //    if (project != null) {
    //        return Response.ok(project).build();
    //    } else {
    //        return Response.status(Response.Status.NOT_FOUND)
    //                .entity("Project not found with ID: " + id).build();
    //    }
    //}
}