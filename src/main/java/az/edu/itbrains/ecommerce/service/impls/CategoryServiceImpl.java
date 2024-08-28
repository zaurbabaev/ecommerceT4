package az.edu.itbrains.ecommerce.service.impls;

import az.edu.itbrains.ecommerce.model.Category;
import az.edu.itbrains.ecommerce.repository.CategoryRepository;
import az.edu.itbrains.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
