package az.edu.itbrains.ecommerce.service;

import az.edu.itbrains.ecommerce.dto.product.ProductDashboardDTO;
import az.edu.itbrains.ecommerce.dto.product.ProductDealDTO;
import az.edu.itbrains.ecommerce.dto.product.ProductDetailDTO;
import az.edu.itbrains.ecommerce.dto.product.ProductRelatedDTO;
import az.edu.itbrains.ecommerce.model.Product;
import az.edu.itbrains.ecommerce.payload.PaginationPayload;

import java.util.List;

public interface ProductService {

    List<Product> getHomeProducts();

    ProductDetailDTO getById(Long id);

    List<ProductRelatedDTO> getRelatedProduct(Long categoryId, Long productId);

    ProductDealDTO getDealProduct();

//    PaginationPayload<ProductDashboardDTO> getDashboardProducts(Integer pageSize, Integer pageNumber, String sortBy, String sortDirection);
    PaginationPayload<ProductDashboardDTO> getDashboardProducts(Integer pageSize);
}
