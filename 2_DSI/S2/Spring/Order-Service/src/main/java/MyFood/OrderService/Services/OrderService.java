package MyFood.OrderService.Services;

import java.util.List;

import MyFood.OrderService.Entities.OrderS;

public interface OrderService {
    OrderS createOrder(OrderS order);
    void cancelOrder(Long orderId);
    OrderS reviseOrder(Long orderId, OrderS revisedOrder);
	List<OrderS> getAllOrders();
    
}




