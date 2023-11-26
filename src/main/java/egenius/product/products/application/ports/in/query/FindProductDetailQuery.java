package egenius.product.products.application.ports.in.query;


import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FindProductDetailQuery {

    private String brandName;
    private List<Long> productDetailIds;

    public static FindProductDetailQuery toQuery(String brandName, List<Long> productDetailIds){
        return FindProductDetailQuery.builder()
                .brandName(brandName)
                .productDetailIds(productDetailIds)
                .build();
    }
}
