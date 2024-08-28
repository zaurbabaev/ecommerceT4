package az.edu.itbrains.ecommerce.dto.user;

import az.edu.itbrains.ecommerce.dto.product.ProductBasketDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBasketDTO {

    private double subtotal;
    private double shipping;
    private double total;

    private List<ProductBasketDTO> products;




}
