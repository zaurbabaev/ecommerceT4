package az.edu.itbrains.ecommerce.service.impls;

import az.edu.itbrains.ecommerce.dto.auth.RegisterDTO;
import az.edu.itbrains.ecommerce.dto.product.ProductBasketDTO;
import az.edu.itbrains.ecommerce.dto.user.UserBasketDTO;
import az.edu.itbrains.ecommerce.model.Basket;
import az.edu.itbrains.ecommerce.model.UserEntity;
import az.edu.itbrains.ecommerce.repository.UserRepository;
import az.edu.itbrains.ecommerce.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.encoder = encoder;
    }


    @Override
    public boolean register(RegisterDTO registerDTO) {
        UserEntity findUser = userRepository.findByEmail(registerDTO.getEmail());
        if (findUser != null) {
            return false;
        }
        UserEntity newUser = modelMapper.map(registerDTO, UserEntity.class);
        newUser.setPassword(encoder.encode(registerDTO.getPassword()));
        userRepository.save(newUser);
        return true;
    }

    @Override
    public UserBasketDTO getUserBasket(String userEmail) {
        UserBasketDTO basket = new UserBasketDTO();
        UserEntity findUser = userRepository.findByEmail(userEmail);
        List<Basket> userBaskets = findUser.getBaskets();
        List<ProductBasketDTO> productBasketDTOList = new ArrayList<>();
        for (Basket b : userBaskets) {
            ProductBasketDTO productBasketDTO = new ProductBasketDTO();
            productBasketDTO.setId(b.getProduct().getId());
            productBasketDTO.setName(b.getProduct().getName());
            productBasketDTO.setPrice(b.getProduct().getPrice());
            productBasketDTO.setImage(b.getProduct().getImage());
            productBasketDTO.setQuantity(b.getQuantity());
            productBasketDTOList.add(productBasketDTO);
        }

        double subtotal = productBasketDTOList.stream()
                .mapToDouble(value -> value.getPrice() * value.getQuantity())
                .sum();
        double shipping = subtotal > 0 ? 1.4 : 0;
        double total = subtotal + shipping;
        basket.setSubtotal(subtotal);
        basket.setShipping(shipping);
        basket.setTotal(total);
        basket.setProducts(productBasketDTOList);
        return basket;
    }
}
