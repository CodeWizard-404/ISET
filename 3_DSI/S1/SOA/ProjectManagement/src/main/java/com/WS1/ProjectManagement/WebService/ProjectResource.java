package com.WS1.ProjectManagement.WebService;

import com.WS1.ProjectManagement.Entities.Project;
import com.WS1.ProjectManagement.Repositories.ProjectRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/projects") 
public class ProjectResource {


    @Autowired
    private ProjectRepository projectRepository;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getAllProjects() {
    	return projectRepository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjectById(@PathParam("id") Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project != null) {
            return Response.ok(project).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Project not found with ID: " + id).build();
        }
    }
}
