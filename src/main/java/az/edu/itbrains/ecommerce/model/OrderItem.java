package az.edu.itbrains.ecommerce.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private double price;

    private Long quantity;

    @ManyToOne
    private Order order;








}
