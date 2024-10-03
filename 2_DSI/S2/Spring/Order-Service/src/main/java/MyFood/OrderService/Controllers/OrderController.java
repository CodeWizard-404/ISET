package MyFood.OrderService.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import MyFood.OrderService.Entities.OrderS;
import MyFood.OrderService.Services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/test")
    public String gettest() {
    	return "Test Order";
    }
    
    @GetMapping
    public ResponseEntity<List<OrderS>> getAllOrders() {
        List<OrderS> orders = orderService.getAllOrders();
        if (!orders.isEmpty()) {
            return ResponseEntity.ok(orders);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<OrderS> createOrder(@RequestBody OrderS order) {
        OrderS createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<?> cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderS> reviseOrder(@PathVariable Long orderId, @RequestBody OrderS revisedOrder) {
        OrderS updatedOrder = orderService.reviseOrder(orderId, revisedOrder);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
