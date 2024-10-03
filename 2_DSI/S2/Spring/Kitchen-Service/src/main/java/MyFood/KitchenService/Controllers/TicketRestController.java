package MyFood.KitchenService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MyFood.KitchenService.Entities.Ticket;
import MyFood.KitchenService.Services.IServiceTicket;

@RestController
@RequestMapping("/api/kitchens")

public class TicketRestController {
	
	@Autowired
	IServiceTicket Sticket;
	
    @GetMapping("/test")
    public String gettest() {
    	return "Test Kitchen";
    }
	
	@PostMapping("/ticket")
	public ResponseEntity<String> addTicket(@RequestBody Ticket ticket) {
	    boolean saved = Sticket.createTicket(ticket);
	    if (saved) {
	        return new ResponseEntity<>("Ticket ajouté avec succès", HttpStatus.CREATED);
	    } else {
	        return new ResponseEntity<>("Erreur lors de l'ajout du ticket", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PutMapping("/order/accepted/{id}")
    public ResponseEntity<Ticket> updateAcceptedTicket(@PathVariable("id") int id) {
		Ticket accepted = Sticket.acceptTicket(id);
        if (accepted != null) {
            return new ResponseEntity<>(accepted, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PutMapping("/order/ready/{id}")
    public ResponseEntity<Ticket> updateReadyTicket(@PathVariable("id") int id) {
		Ticket ready = Sticket.readyForPickUp(id);
        if (ready != null) {
            return new ResponseEntity<>(ready, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	


}
