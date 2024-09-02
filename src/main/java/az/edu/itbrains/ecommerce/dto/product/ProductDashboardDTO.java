package az.edu.itbrains.ecommerce.dto.product;

import az.edu.itbrains.ecommerce.dto.category.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDashboardDTO {

    private Long id;
    private String name;
    private double price;
    private String image;
    CategoryDTO category;


}
