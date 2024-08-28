package az.edu.itbrains.ecommerce.dto.product;

import az.edu.itbrains.ecommerce.dto.category.CategoryDTO;
import az.edu.itbrains.ecommerce.model.Product;

public interface ProductMapper {

    static ProductDetailDTO toDetailDto(Product product) {
        CategoryDTO categoryDTO = new CategoryDTO(
                product.getCategory().getId(),
                product.getCategory().getName());
        return new ProductDetailDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImage(),
                product.getDescription(),
                categoryDTO
        );
    }

    static ProductDealDTO toDealDto(Product product) {
        return ProductDealDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .image(product.getImage())
                .description(product.getDescription())
                .discountDate(product.getDiscountDate())
                .build();
    }

    static ProductRelatedDTO toRelatedDto(Product product) {
        return new ProductRelatedDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImage()
        );
    }


    static ProductHomeDTO toHomeDto(Product product) {
        return new ProductHomeDTO(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImage());
    }


}
