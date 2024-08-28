package az.edu.itbrains.ecommerce.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBasketDTO {

    private Long id;
    private String name;
    private double price;
    private String image;
    private Long quantity;


}
