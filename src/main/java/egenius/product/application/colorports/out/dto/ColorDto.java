package egenius.product.application.colorports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ColorDto {

    private Long colorId;
    private String colorName;

    public static ColorDto formColorDto(Long colorId, String ColorName) {
        return ColorDto.builder()
                .colorId(colorId)
                .colorName(ColorName)
                .build();
    }
}
