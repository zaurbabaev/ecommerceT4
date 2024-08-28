package az.edu.itbrains.ecommerce.dto.testimonial;

public record TestimonialDTO(
        Long id,
        String fullName,
        String position,
        String image,
        String description
) {
}
