package az.edu.itbrains.ecommerce.controller.dashboard;

import az.edu.itbrains.ecommerce.dto.category.CategoryCreateDTO;
import az.edu.itbrains.ecommerce.dto.category.CategoryDTO;
import az.edu.itbrains.ecommerce.dto.category.CategoryDashboardDTO;
import az.edu.itbrains.ecommerce.dto.category.CategoryUpdateDTO;
import az.edu.itbrains.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        List<CategoryDashboardDTO> categories = service.getDashBoardsCategories();
        model.addAttribute("categories", categories);
        return "dashboard/category/index";
    }

    @GetMapping("/create")
    public String create() {
        return "dashboard/category/create";
    }

    @PostMapping("/create")
    public String create(CategoryCreateDTO categoryCreate) {
        boolean category = service.createCategory(categoryCreate);
        if (category) {
            return "redirect:/admin/category";
        }
        return "redirect:/dashboard/category/create";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        CategoryDTO category = service.getCategory(id);
        model.addAttribute("category", category);
        return "dashboard/category/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, CategoryUpdateDTO categoryUpdate) {
        boolean updateCategory = service.updateCategory(id, categoryUpdate);
        if(updateCategory){
            return "redirect:/admin/category";
        }
        return "dashboard/category/update";
    }

    @GetMapping("/delete")
    public String delete() {
        return "dashboard/category/delete";
    }


}
