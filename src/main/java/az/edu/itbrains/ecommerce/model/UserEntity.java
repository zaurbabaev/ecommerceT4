package az.edu.itbrains.ecommerce.model;


import az.edu.itbrains.ecommerce.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthdayDate;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "user")
    private List<Basket> baskets;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

}
