package az.edu.itbrains.ecommerce.dto.product;

public record ProductRelatedDTO(
        Long id,
        String name,
        double price,
        String image
) {
}
