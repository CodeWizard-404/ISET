package MyFood.OrderService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import MyFood.OrderService.Entities.OrderS;

public interface OrderRepositorie extends JpaRepository<OrderS, Long> {

}
