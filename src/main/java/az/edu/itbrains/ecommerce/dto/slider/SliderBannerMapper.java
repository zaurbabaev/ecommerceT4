package az.edu.itbrains.ecommerce.dto.slider;

import az.edu.itbrains.ecommerce.model.Slider;

public interface SliderBannerMapper {

    static SliderBannerDTO tosliderBannerDto(Slider slider) {
        return new SliderBannerDTO(
                slider.getId(),
                slider.getTitle(),
                slider.getDescription(),
                slider.getImage()
        );
    }
}
