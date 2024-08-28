package az.edu.itbrains.ecommerce.service;

import az.edu.itbrains.ecommerce.dto.testimonial.TestimonialDTO;

import java.util.List;


public interface TestimonialService {

    List<TestimonialDTO> getTestimonials();
}
