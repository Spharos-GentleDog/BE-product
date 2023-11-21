package egenius.product.VendorProduct.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetSalesCountDto {

    private Long productDetailId; // 상품 상세 ID
    private Integer salesCount; // 판매 수량
    private Integer displayStatus; // 상품 노출 상태

    public static GetSalesCountDto fromSalesCount(Long productDetailId, Integer salesCount, Integer displayStatus){
        return GetSalesCountDto.builder()
                .productDetailId(productDetailId)
                .salesCount(salesCount)
                .displayStatus(displayStatus)
                .build();
    }


}
