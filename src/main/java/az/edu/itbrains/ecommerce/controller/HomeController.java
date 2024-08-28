package az.edu.itbrains.ecommerce.controller;

import az.edu.itbrains.ecommerce.dto.product.ProductDealDTO;
import az.edu.itbrains.ecommerce.dto.slider.SliderBannerDTO;
import az.edu.itbrains.ecommerce.dto.testimonial.TestimonialDTO;
import az.edu.itbrains.ecommerce.model.Category;
import az.edu.itbrains.ecommerce.model.Product;
import az.edu.itbrains.ecommerce.service.CategoryService;
import az.edu.itbrains.ecommerce.service.ProductService;
import az.edu.itbrains.ecommerce.service.SliderService;
import az.edu.itbrains.ecommerce.service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
public class HomeController {

//    public static List<Product> productList;
//
//    {
//        productList = new ArrayList<>();
//        productList.add(new Product(1L, "Banana", 0.99, "https://cdn.pixabay.com/photo/2017/06/27/22/21/banana-2449019_1280.jpg"));
//        productList.add(new Product(2L, "Pineapple", 2.99, "https://cdn.pixabay.com/photo/2020/04/29/12/47/pineapple-5108775_1280.jpg"));
//        productList.add(new Product(3L, "Peach", 1.89, "https://cdn.pixabay.com/photo/2010/12/13/10/06/food-2279_1280.jpg"));
//        productList.add(new Product(4L, "Apple", 1.99, "https://cdn.pixabay.com/photo/2016/02/23/17/44/apple-1218166_1280.png"));
//        productList.add(new Product(5L, "Grapes", 2.49, "https://cdn.pixabay.com/photo/2016/02/23/17/47/grape-1218185_1280.png"));
//        productList.add(new Product(6L, "Watermelon", 3.99, "https://cdn.pixabay.com/photo/2018/08/04/23/43/watermelon-3584717_1280.jpg"));
//        productList.add(new Product(7L, "Strawberry", 2.99, "https://cdn.pixabay.com/photo/2016/03/05/19/11/strawberry-1238295_1280.jpg"));
//        productList.add(new Product(8L, "Mango", 1.99, "https://cdn.pixabay.com/photo/2018/03/18/15/50/food-3237172_1280.jpg"));
//        productList.add(new Product(9L, "Blueberry", 4.99, "https://cdn.pixabay.com/photo/2015/08/03/19/20/blueberry-873784_1280.jpg"));
//        productList.add(new Product(10L, "Orange", 1.49, "https://cdn.pixabay.com/photo/2016/02/25/16/33/fruit-1222438_1280.png"));
//    }


//    @GetMapping("/")
//    public String index(Model model) {
//        List<Product> limitedList = productList.stream()
//                .limit(3)
//                .collect(Collectors.toList());
//        model.addAttribute("products", limitedList);
//        return "home"; // home.html sehifesi bizim templatede index_2
//    }

    // yuxarı hissədə məlumatlar listdən gətilir

    private final CategoryService categoryService;
    private final ProductService productService;
    private final SliderService sliderService;
    private final TestimonialService testimonialService;


    @Autowired
    public HomeController(CategoryService categoryService, ProductService productService, SliderService sliderService, TestimonialService testimonialService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.sliderService = sliderService;
        this.testimonialService = testimonialService;
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Category> allCategories = categoryService.getAllCategories();
        List<Product> allProducts = productService.getHomeProducts();
        List<Product> limitList = allProducts.stream()
                .limit(3)
                .toList();
        List<SliderBannerDTO> sliders = sliderService.getSlider();
        ProductDealDTO dealProduct = productService.getDealProduct();
        List<TestimonialDTO> testimonials = testimonialService.getTestimonials();
        model.addAttribute("categories", allCategories);
        model.addAttribute("products", limitList);
        model.addAttribute("sliders", sliders);
        model.addAttribute("deal", dealProduct);
        model.addAttribute("testimonials", testimonials);
        return "home";
    }


}
