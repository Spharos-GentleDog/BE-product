package egenius.product.colors.adaptor.infrastructure.mysql.persistance;

import egenius.product.colors.adaptor.infrastructure.mysql.entity.ColorEntity;
import egenius.product.colors.adaptor.infrastructure.mysql.repository.ColorRepository;
import egenius.product.colors.application.ports.out.dto.ColorDto;
import egenius.product.colors.application.ports.out.dto.ReadColorsDto;
import egenius.product.colors.application.ports.out.port.CreateColorPort;
import egenius.product.colors.application.ports.out.port.ReadColorsPort;
import egenius.product.colors.domain.Colors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class ColorAdaptor implements CreateColorPort, ReadColorsPort {

    private final ColorRepository colorRepository;

    @Override
    public void createColor(Colors colors) {

        ColorEntity colorEntity = colorRepository.save(ColorEntity.createColor(
                colors.getColorCode(),
                colors.getColorName(),
                colors.getColorRed(),
                colors.getColorGreen(),
                colors.getColorBlue()
        ));

    }

    @Override
    public ReadColorsDto readColors() {

        List<ColorEntity> colorEntities = colorRepository.findAll();

        List<ColorDto> colorDtoList =
                colorEntities.stream()
                .map(colorEntity -> ColorDto.formColorDto(colorEntity.getId(), colorEntity.getColorName()))
                .collect(Collectors.toList());

        return ReadColorsDto.fromReadColorsDto(colorDtoList);
    }
}
