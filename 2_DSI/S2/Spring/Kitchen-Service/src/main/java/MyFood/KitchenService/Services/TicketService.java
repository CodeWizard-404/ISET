package MyFood.KitchenService.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MyFood.KitchenService.Entities.Ticket;
import MyFood.KitchenService.Repositories.TicketRepository;


@Service
public class TicketService implements IServiceTicket{

	@Autowired
	private TicketRepository TicketService;
	
	@Override
	public boolean createTicket(Ticket ticket) {
		if(TicketService.save(ticket) != null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Ticket acceptTicket(int id) {
		Ticket ticket = TicketService.findById(id).get();
		ticket.setState(ticket.getState().accepted);
		TicketService.save(ticket);
		return ticket;
	}

	@Override
	public Ticket readyForPickUp(int id) {
		Ticket ticket = TicketService.findById(id).get();
		ticket.setState(ticket.getState().ready);
		TicketService.save(ticket);
		return ticket;
	}

}
