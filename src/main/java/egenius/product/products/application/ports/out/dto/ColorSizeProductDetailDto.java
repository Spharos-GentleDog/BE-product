package egenius.product.products.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ColorSizeProductDetailDto {

    private Long productDetailId;

    public static ColorSizeProductDetailDto formColorSizeProductDetailDto(Long productDetailId){
        return ColorSizeProductDetailDto.builder()
                .productDetailId(productDetailId)
                .build();
    }
}

