package az.edu.itbrains.ecommerce.service.impls;

import az.edu.itbrains.ecommerce.dto.slider.SliderBannerDTO;
import az.edu.itbrains.ecommerce.dto.slider.SliderBannerMapper;
import az.edu.itbrains.ecommerce.model.Slider;
import az.edu.itbrains.ecommerce.repository.SliderRepository;
import az.edu.itbrains.ecommerce.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SliderServiceImpl implements SliderService {

    private final SliderRepository sliderRepository;

    @Autowired
    public SliderServiceImpl(SliderRepository sliderRepository) {
        this.sliderRepository = sliderRepository;
    }

    @Override
    public List<SliderBannerDTO> getSlider() {
        List<Slider> sliderList = sliderRepository.findAll();
        return sliderList.stream()
                .map(SliderBannerMapper::tosliderBannerDto)
                .toList();
    }
}


