package az.edu.itbrains.ecommerce.dto.basket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasketAddDTO {

    private Long productId;

    private Long quantity;


}
