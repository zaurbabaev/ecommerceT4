package az.edu.itbrains.ecommerce.dto.category;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdateDTO {

    private Long id;
    private String name;

}
