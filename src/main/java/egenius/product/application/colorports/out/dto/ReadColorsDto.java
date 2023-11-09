package egenius.product.application.colorports.out.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ReadColorsDto {

    private List<ColorDto> colors;

    public static ReadColorsDto fromReadColorsDto(List<ColorDto> readColorsDto) {
        return ReadColorsDto.builder()
                .colors(readColorsDto)
                .build();
    }
}
