package az.edu.itbrains.ecommerce.service;

import az.edu.itbrains.ecommerce.dto.category.CategoryCreateDTO;
import az.edu.itbrains.ecommerce.dto.category.CategoryDTO;
import az.edu.itbrains.ecommerce.dto.category.CategoryDashboardDTO;
import az.edu.itbrains.ecommerce.dto.category.CategoryUpdateDTO;
import az.edu.itbrains.ecommerce.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    List<CategoryDashboardDTO> getDashBoardsCategories();

    boolean createCategory(CategoryCreateDTO categoryCreate);

    boolean updateCategory(Long id, CategoryUpdateDTO categoryUpdate);

    CategoryDTO getCategory(Long id);

}
