package az.edu.itbrains.ecommerce.dto.product;

import az.edu.itbrains.ecommerce.dto.category.CategoryDTO;


public record ProductDetailDTO(Long id,
                               String name,
                               double price,
                               String image,
                               String description,
                               CategoryDTO categoryDTO
) {


}
