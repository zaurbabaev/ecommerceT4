package az.edu.itbrains.ecommerce.service;


import az.edu.itbrains.ecommerce.dto.auth.RegisterDTO;
import az.edu.itbrains.ecommerce.dto.user.UserBasketDTO;

import java.util.List;

public interface UserService {

    boolean register(RegisterDTO registerDTO);

    UserBasketDTO getUserBasket(String userEmail);

}
