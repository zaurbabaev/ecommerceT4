package az.edu.itbrains.ecommerce.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateDTO {

    private Long id;

    private Long quantity;


}
