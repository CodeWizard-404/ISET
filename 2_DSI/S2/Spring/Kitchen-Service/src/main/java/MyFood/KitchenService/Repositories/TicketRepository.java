package MyFood.KitchenService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import MyFood.KitchenService.Entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}