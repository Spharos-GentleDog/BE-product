package egenius.product.products.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDetailPageOptionsDto {

    private Long productDetailId;
    private Integer discountRate;
    private Integer discountType;
    private String Size;
    private String Color;

    public static ProductDetailPageOptionsDto formProductDetailPageOptionsDto(Long productDetailId,
                                                                              Integer discountRate,
                                                                              Integer discountType,
                                                                              String Size, String Color){
        return ProductDetailPageOptionsDto.builder()
                .productDetailId(productDetailId)
                .discountRate(discountRate)
                .discountType(discountType)
                .Size(Size)
                .Color(Color)
                .build();
    }

}
