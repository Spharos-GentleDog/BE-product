package egenius.product.VendorProduct.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetSalesCountQuery {

    private Long productDetailId; // 상품 상세 ID

    public static GetSalesCountQuery toQuery(Long productDetailId){
        return GetSalesCountQuery.builder()
                .productDetailId(productDetailId)
                .build();
    }
}
