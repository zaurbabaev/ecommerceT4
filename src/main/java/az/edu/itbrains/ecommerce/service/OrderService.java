package az.edu.itbrains.ecommerce.service;

import az.edu.itbrains.ecommerce.dto.order.PlaceOrderDTO;

public interface OrderService {
    boolean checkout(String userEmail, PlaceOrderDTO orderDTO);

}
