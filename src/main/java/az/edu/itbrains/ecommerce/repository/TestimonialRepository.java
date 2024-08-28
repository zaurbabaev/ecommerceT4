package az.edu.itbrains.ecommerce.repository;

import az.edu.itbrains.ecommerce.model.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {

}
