package az.edu.itbrains.ecommerce.service.impls;

import az.edu.itbrains.ecommerce.dto.basket.BasketAddDTO;
import az.edu.itbrains.ecommerce.model.Basket;
import az.edu.itbrains.ecommerce.model.Product;
import az.edu.itbrains.ecommerce.model.UserEntity;
import az.edu.itbrains.ecommerce.repository.BasketRepository;
import az.edu.itbrains.ecommerce.repository.ProductRepository;
import az.edu.itbrains.ecommerce.repository.UserRepository;
import az.edu.itbrains.ecommerce.service.BasketService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService {


    private final BasketRepository basketRepository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;
    private final Product product;

    public BasketServiceImpl(BasketRepository basketRepository, UserRepository userRepository, ProductRepository productRepository, ModelMapper modelMapper, Product product) {
        this.basketRepository = basketRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.product = product;
    }

    @Override
    public boolean removeFromBasket(Long productId, String userEmail) {
        UserEntity findUser = userRepository.findByEmail(userEmail);
        Basket filterBasket = basketRepository
                .findByUserIdAndProductId(findUser.getId(), productId);
        basketRepository.delete(filterBasket);
        return true;
    }

    @Override
    public boolean addToBasket(BasketAddDTO basketAddDTO, String username) {
        UserEntity findUser = userRepository.findByEmail(username);
        Product findProduct = productRepository.findById(basketAddDTO.getProductId())
                .orElseThrow();
        Basket filterBasket = basketRepository
                .findByUserIdAndProductId(findUser.getId(), findProduct.getId());

        if (filterBasket == null) {
            Basket basket = new Basket();
            basket.setProduct(findProduct);
            basket.setQuantity(basketAddDTO.getQuantity());
            basket.setUser(findUser);
            basketRepository.save(basket);
        } else {
            filterBasket.setQuantity(filterBasket.getQuantity() + basketAddDTO.getQuantity());
            basketRepository.save(filterBasket);
        }

        return true;
    }
}
