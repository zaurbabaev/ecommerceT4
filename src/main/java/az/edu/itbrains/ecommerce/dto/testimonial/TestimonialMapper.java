package az.edu.itbrains.ecommerce.dto.testimonial;

import az.edu.itbrains.ecommerce.model.Testimonial;

public interface TestimonialMapper {

    static TestimonialDTO toTestimonialDto(Testimonial testimonial) {
        return new TestimonialDTO(
                testimonial.getId(),
                testimonial.getFullName(),
                testimonial.getPosition(),
                testimonial.getImage(),
                testimonial.getDescription()
        );
    }
}
