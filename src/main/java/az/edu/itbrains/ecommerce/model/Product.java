package az.edu.itbrains.ecommerce.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String image;
    @Column(columnDefinition = "TEXT")
    private String description;
        @Column(nullable = true)
    private double discountPrice;
    private LocalDate discountDate;
        @Column(nullable = true)
    boolean featured;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
