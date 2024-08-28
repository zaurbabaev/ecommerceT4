package az.edu.itbrains.ecommerce.service.impls;

import az.edu.itbrains.ecommerce.enums.OrderStatus;
import az.edu.itbrains.ecommerce.enums.PaymentStatus;
import az.edu.itbrains.ecommerce.model.Basket;
import az.edu.itbrains.ecommerce.model.Order;
import az.edu.itbrains.ecommerce.model.OrderItem;
import az.edu.itbrains.ecommerce.model.UserEntity;
import az.edu.itbrains.ecommerce.repository.BasketRepository;
import az.edu.itbrains.ecommerce.repository.OrderItemRepository;
import az.edu.itbrains.ecommerce.repository.OrderRepository;
import az.edu.itbrains.ecommerce.repository.UserRepository;
import az.edu.itbrains.ecommerce.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    private final UserRepository userRepository;

    private final BasketRepository basketRepository;

    private final ModelMapper modelMapper;

    private OrderItemRepository orderItemRepository;

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(UserRepository userRepository, BasketRepository basketRepository, ModelMapper modelMapper, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
        this.modelMapper = modelMapper;
        this.orderRepository = orderRepository;
    }


    @Override
    public boolean checkout(String userEmail) {
        UserEntity findUser = userRepository.findByEmail(userEmail);
        Order order = new Order();
        order.setUser(findUser);
        order.setOrderDate(LocalDate.now());
        order.setOrderStatus(OrderStatus.PENDING);
        order.setPaymentStatus(PaymentStatus.PENDING);
        orderRepository.save(order);
        List<Basket> userBaskets = findUser.getBaskets();
        userBaskets.forEach(basket -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(basket.getProduct());
            orderItem.setQuantity(basket.getQuantity());
            orderItem.setPrice(basket.getProduct().getPrice());
            orderItem.setOrder(order);
            orderItemRepository.save(orderItem);
        });

        // Ödeniş mərhələsi

        return false;
    }
}
