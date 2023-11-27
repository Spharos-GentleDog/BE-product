package egenius.product.products.application.ports.out.dto;

import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AiServiceProductDetailsDto {

    private Long productDetailId;
    private String color;
    private String size;
    private Integer discountRate;
    private Integer discountTypes; // enum 타입의 code 저장 (0: 퍼센트, 1: 금액)



    public static AiServiceProductDetailsDto formAiServiceProductDetailsDto(Long productDetailId, String color,
                                                                            String size, Integer discountRate,
                                                                            Integer discountTypes){
        return AiServiceProductDetailsDto.builder()
                .productDetailId(productDetailId)
                .color(color)
                .size(size)
                .discountRate(discountRate)
                .discountTypes(discountTypes)
                .build();
    }
}
