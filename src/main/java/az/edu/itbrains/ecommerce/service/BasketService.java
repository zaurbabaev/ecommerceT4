package az.edu.itbrains.ecommerce.service;

import az.edu.itbrains.ecommerce.dto.basket.BasketAddDTO;

public interface BasketService {

    boolean addToBasket(BasketAddDTO basketAddDTO,String username);

    boolean removeFromBasket(Long productId, String userEmail);
}
