package egenius.product.products.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DiscountsDto {

    private Long productDetailId; // 세부 상품
    private Integer discountRate; // 할인율
    private Integer discountType; // 할인 유형

    public static DiscountsDto formDiscountsDto(Long productDetailId, Integer discountRate, Integer discountType) {
        return DiscountsDto.builder()
                .productDetailId(productDetailId)
                .discountRate(discountRate)
                .discountType(discountType)
                .build();
    }
}
