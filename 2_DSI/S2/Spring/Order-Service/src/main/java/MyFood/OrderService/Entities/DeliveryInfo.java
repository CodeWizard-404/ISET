package MyFood.OrderService.Entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "delivery_info")
public class DeliveryInfo implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delivery_time")
    private int deliveryTime;

    @Column(name = "delivery_address")
    private String deliveryAddress;
    
    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderS order;

    public DeliveryInfo() {}

    public DeliveryInfo(int deliveryTime, String deliveryAddress, OrderS order) {
        this.deliveryTime = deliveryTime;
        this.deliveryAddress = deliveryAddress;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public OrderS getOrder() {
        return order;
    }

    public void setOrder(OrderS order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "DeliveryInfo [id=" + id + ", deliveryTime=" + deliveryTime + ", deliveryAddress=" + deliveryAddress
                + "]";
    }    
}
