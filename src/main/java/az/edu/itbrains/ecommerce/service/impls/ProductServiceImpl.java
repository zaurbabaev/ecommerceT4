package az.edu.itbrains.ecommerce.service.impls;

import az.edu.itbrains.ecommerce.dto.product.*;
import az.edu.itbrains.ecommerce.model.Product;
import az.edu.itbrains.ecommerce.payload.PaginationPayload;
import az.edu.itbrains.ecommerce.repository.ProductRepository;
import az.edu.itbrains.ecommerce.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
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


    @Override
    public PaginationPayload<ProductDashboardDTO> getDashboardProducts(Integer pageNumber) {
//        Sort sort;
//        if (sortDirection.equalsIgnoreCase("asc")) {
//            sort = Sort.by(sortBy).ascending();
//        } else {
//            sort = Sort.by(sortBy).descending();
//        }

        pageNumber = pageNumber == null ? 1 : pageNumber;

        Pageable pageable = PageRequest.of(pageNumber-1, 10, Sort.by("id"));

        Page<Product> productsPage = productRepository.findAll(pageable);

        List<ProductDashboardDTO> productsDTOs = productsPage.stream()
                .map(product -> modelMapper.map(product, ProductDashboardDTO.class))
                .toList();

        PaginationPayload<ProductDashboardDTO> paginationPayload = new PaginationPayload<>();
        paginationPayload.setData(productsDTOs);
        paginationPayload.setTotalPage(productsPage.getTotalPages());

        return paginationPayload;
    }


}

