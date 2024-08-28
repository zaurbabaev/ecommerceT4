package az.edu.itbrains.ecommerce.controller;

import az.edu.itbrains.ecommerce.dto.basket.BasketAddDTO;
import az.edu.itbrains.ecommerce.dto.product.ProductDetailDTO;
import az.edu.itbrains.ecommerce.dto.product.ProductRelatedDTO;
import az.edu.itbrains.ecommerce.dto.user.UserBasketDTO;
import az.edu.itbrains.ecommerce.service.BasketService;
import az.edu.itbrains.ecommerce.service.ProductService;
import az.edu.itbrains.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class ShopController {

//    @GetMapping("/detail/{id}")
//    public String detail(@PathVariable Long id, Model model) {
//        Optional<Product> optional = HomeController.productList
//                .stream()
//                .filter(p -> p.getId().equals(id))
//                .findAny();
//        Product product = optional.get();
//        model.addAttribute("product",product);
//        return "shop/detail";
//    }

// yuxarı hissədə məlumatlar HomeController daxilində olan listdən gəlir


    private final ProductService productService;

    private final BasketService basketService;

    private final UserService userService;

    @Autowired
    public ShopController(ProductService productService, BasketService basketService, UserService userService) {
        this.productService = productService;
        this.basketService = basketService;
        this.userService = userService;
    }

    @GetMapping("/shop")
    public String index() {
        return "shop/index";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        ProductDetailDTO product = productService.getById(id);
        List<ProductRelatedDTO> relatedProducts = productService.getRelatedProduct(product.categoryDTO().id(), id);
        model.addAttribute("product", product);
        model.addAttribute("relatedProducts", relatedProducts);
        return "shop/detail";
    }

    @GetMapping("/basket")
    public String basket(Model model, Principal principal) {
        UserBasketDTO userBasket = userService.getUserBasket(principal.getName());
        model.addAttribute("basket", userBasket);
        return "shop/basket";
    }

    @PostMapping("/basket")
    public String basket(BasketAddDTO basketAddDTO, Principal principal) {
        basketService.addToBasket(basketAddDTO, principal.getName());
        return "redirect:/basket";
    }

    @GetMapping("/basket/{productId}")
    public String removeBasket(@PathVariable Long productId, Principal principal) {
        basketService.removeFromBasket(productId, principal.getName());
        return "redirect:/basket";

    }

    @GetMapping("/checkout")
    public String checkout(){
        return "shop/checkout";
    }


}
