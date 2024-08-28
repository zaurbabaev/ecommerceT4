package az.edu.itbrains.ecommerce.service;

import az.edu.itbrains.ecommerce.dto.slider.SliderBannerDTO;

import java.util.List;

public interface SliderService {

    List<SliderBannerDTO> getSlider();
}
