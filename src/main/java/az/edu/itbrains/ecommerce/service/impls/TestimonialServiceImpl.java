package az.edu.itbrains.ecommerce.service.impls;

import az.edu.itbrains.ecommerce.dto.testimonial.TestimonialDTO;
import az.edu.itbrains.ecommerce.dto.testimonial.TestimonialMapper;
import az.edu.itbrains.ecommerce.model.Testimonial;
import az.edu.itbrains.ecommerce.repository.TestimonialRepository;
import az.edu.itbrains.ecommerce.service.TestimonialService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    private final TestimonialRepository testimonialRepository;

    public TestimonialServiceImpl(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }


    @Override
    public List<TestimonialDTO> getTestimonials() {
        List<Testimonial> testimonialList = testimonialRepository.findAll();
        return testimonialList.stream()
                .map(TestimonialMapper::toTestimonialDto)
                .toList();
    }
}
