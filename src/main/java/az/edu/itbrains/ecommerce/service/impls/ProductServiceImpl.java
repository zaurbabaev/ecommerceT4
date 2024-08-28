package az.edu.itbrains.ecommerce.service.impls;

import az.edu.itbrains.ecommerce.dto.product.ProductDealDTO;
import az.edu.itbrains.ecommerce.dto.product.ProductDetailDTO;
import az.edu.itbrains.ecommerce.dto.product.ProductMapper;
import az.edu.itbrains.ecommerce.dto.product.ProductRelatedDTO;
import az.edu.itbrains.ecommerce.model.Product;
import az.edu.itbrains.ecommerce.repository.ProductRepository;
import az.edu.itbrains.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getHomeProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductDetailDTO getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return ProductMapper.toDetailDto(product);
    }

    @Override
    public ProductDealDTO getDealProduct() {
        Product product = productRepository.findByFeaturedTrue();
        double percent = product.getDiscountPrice() * 100 / product.getPrice();
        double discountPercent = ProductDealDTO.builder()
                .discountPercent(percent)
                .build().discountPercent();
        return new ProductDealDTO(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImage(),
                product.getDescription(),
                (Math.floor(discountPercent)),
                product.getDiscountDate());
    }

    @Override
    public List<ProductRelatedDTO> getRelatedProduct(Long categoryId, Long productId) {
        List<Product> products = productRepository.findByCategoryId(categoryId)
                .stream()
                .filter(product -> !Objects.equals(product.getId(), productId))
                .limit(3).toList();
        return products.stream()
                .map(ProductMapper::toRelatedDto).toList();
    }

}

