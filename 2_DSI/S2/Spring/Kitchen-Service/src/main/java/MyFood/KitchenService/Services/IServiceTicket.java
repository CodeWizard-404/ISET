package MyFood.KitchenService.Services;

import MyFood.KitchenService.Entities.Ticket;

public interface IServiceTicket {
	
	public boolean createTicket(Ticket ticket);
	
	public Ticket acceptTicket(int id);
	
	public Ticket readyForPickUp(int id);

}
