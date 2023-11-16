package egenius.product.products.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CreateProductDto {

    private List<Long> productDetailId; // 상품 상세 ID

    public static CreateProductDto fromProductDetailId(List<Long> productDetailId){
        return CreateProductDto.builder()
                .productDetailId(productDetailId)
                .build();
    }
}
