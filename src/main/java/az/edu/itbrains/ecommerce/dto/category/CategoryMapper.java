package az.edu.itbrains.ecommerce.dto.category;

import az.edu.itbrains.ecommerce.model.Category;

public interface CategoryMapper {
    static CategoryDTO toCategoryDto(Category category) {
        return new CategoryDTO(category.getId(), category.getName());
    }
}
