package egenius.product.products.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderProductInfoQuery {

    private Long productDetailId;
    private Integer count;

    public static OrderProductInfoQuery toQuery(Long productDetailId, Integer count){
        return OrderProductInfoQuery.builder()
                .productDetailId(productDetailId)
                .count(count)
                .build();
    }
}
