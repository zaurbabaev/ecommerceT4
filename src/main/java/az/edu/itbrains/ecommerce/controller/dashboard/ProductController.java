package az.edu.itbrains.ecommerce.controller.dashboard;

import az.edu.itbrains.ecommerce.dto.product.ProductDashboardDTO;
import az.edu.itbrains.ecommerce.payload.PaginationPayload;
import az.edu.itbrains.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String index(Integer currentPage, Model model) {
        PaginationPayload<ProductDashboardDTO> result = productService.getDashboardProducts(currentPage);
        model.addAttribute("products", result);
        return "dashboard/product/index";
    }



}
