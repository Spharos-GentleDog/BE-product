package egenius.product.products.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ColorSizeProductDetailQuery {

    private Long productId;
    private String color;
    private String size;

    public static ColorSizeProductDetailQuery toQuery(Long productId, String color, String size){
        return ColorSizeProductDetailQuery.builder()
                .productId(productId)
                .color(color)
                .size(size)
                .build();
    }


}
