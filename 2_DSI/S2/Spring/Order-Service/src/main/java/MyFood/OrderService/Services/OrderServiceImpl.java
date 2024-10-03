package MyFood.OrderService.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MyFood.OrderService.Entities.OrderS;
import MyFood.OrderService.Repositories.OrderRepositorie;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepositorie orderRepository;

    public OrderS createOrder(OrderS order) {
        order.setState("created");
        return orderRepository.save(order);
    }

    public void cancelOrder(Long orderId) {
        orderRepository.findById(orderId).ifPresent(order -> {
            order.setState("canceled");
            orderRepository.save(order);
        });
    }

    public OrderS reviseOrder(Long orderId, OrderS revisedOrder) {
        return orderRepository.findById(orderId).map(order -> {
            order.setState(revisedOrder.getState());
            order.setConsumerId(revisedOrder.getConsumerId());
            order.setRestaurantId(revisedOrder.getRestaurantId());
            return orderRepository.save(order);
        }).orElse(null);
    }

	@Override
    public List<OrderS> getAllOrders() {
        return orderRepository.findAll();
    }

}

