package egenius.product.products.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AiServiceProductDetailQuery {

    private List<Long> productIdList;

    public static AiServiceProductDetailQuery toQuery(List<Long> productIdList){
        return AiServiceProductDetailQuery.builder()
                .productIdList(productIdList)
                .build();
    }

}
