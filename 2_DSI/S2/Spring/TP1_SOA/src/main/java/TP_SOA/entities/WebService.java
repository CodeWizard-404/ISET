package TP_SOA.entities;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import TP_SOA.Reposetories.CitoyenRepo;
import jakarta.ws.rs.GET;

@Path("service")
public class WebService {
	@Autowired
	private CitoyenRepo citoyenRepo;
	
	@GET
	@Path("/citoyens/{cin}")
	@Produces(MediaType.APPLICATION_JSON)
	public Citoyen getExtraiit(@PathParam("cin") String id) {
		Optional<Citoyen> c=citoyenRepo.findById(id);
		if(c.isPresent())
			return c.get();
		else
			return null;
		
	}
}
