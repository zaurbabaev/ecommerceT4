package az.edu.itbrains.ecommerce.service.impls;

import az.edu.itbrains.ecommerce.dto.category.CategoryCreateDTO;
import az.edu.itbrains.ecommerce.dto.category.CategoryDTO;
import az.edu.itbrains.ecommerce.dto.category.CategoryDashboardDTO;
import az.edu.itbrains.ecommerce.dto.category.CategoryUpdateDTO;
import az.edu.itbrains.ecommerce.model.Category;
import az.edu.itbrains.ecommerce.repository.CategoryRepository;
import az.edu.itbrains.ecommerce.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public List<CategoryDashboardDTO> getDashBoardsCategories() {
        return repository.findAll().stream()
                .map(category -> modelMapper.map(category, CategoryDashboardDTO.class)).toList();
    }

    @Override
    public boolean createCategory(CategoryCreateDTO categoryCreate) {
        try {
            Category category = modelMapper.map(categoryCreate, Category.class);
            repository.save(category);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public CategoryDTO getCategory(Long id) {
        Category category = repository.findById(id).orElseThrow();
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public boolean updateCategory(Long id, CategoryUpdateDTO categoryUpdate) {
        try {
            Category findCategory = repository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Category not found"));
            findCategory.setName(categoryUpdate.getName());
            repository.save(findCategory);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


}
