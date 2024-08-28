package az.edu.itbrains.ecommerce.controller;

import az.edu.itbrains.ecommerce.dto.auth.RegisterDTO;
import az.edu.itbrains.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(RegisterDTO registerDTO) {
        boolean result = userService.register(registerDTO);
        return result ?
                "redirect:/login" : // true-dirsə buraya
                "redirect:/register"; // false-dirsə buraya
    }


}
