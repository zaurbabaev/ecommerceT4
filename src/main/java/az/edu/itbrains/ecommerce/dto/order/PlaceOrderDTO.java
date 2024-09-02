package az.edu.itbrains.ecommerce.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceOrderDTO {

    private String address;

    private String phoneNumber;

    private String message;

}
