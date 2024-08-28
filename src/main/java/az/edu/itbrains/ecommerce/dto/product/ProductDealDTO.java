package az.edu.itbrains.ecommerce.dto.product;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ProductDealDTO(
        Long id,
        String name,
        double price,
        String image,
        String description,
        double discountPercent,
        LocalDate discountDate
) {
}
