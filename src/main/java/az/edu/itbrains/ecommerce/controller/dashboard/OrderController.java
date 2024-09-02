package az.edu.itbrains.ecommerce.controller.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/order")
public class OrderController {

    @GetMapping
    public String index() {
        return "dashboard/order/index";
    }


}
