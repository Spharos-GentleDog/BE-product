package egenius.product.products.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ColorDto {

    private String colorName;
    private String colorCode;

    public static ColorDto formColorDto(String colorName, String colorCode){
        return ColorDto.builder()
                .colorName(colorName)
                .colorCode(colorCode)
                .build();
    }
}
