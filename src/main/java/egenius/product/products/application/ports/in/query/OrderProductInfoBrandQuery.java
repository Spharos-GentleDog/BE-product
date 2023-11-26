package egenius.product.products.application.ports.in.query;

import jdk.dynalink.linker.LinkerServices;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OrderProductInfoBrandQuery {

    private List<OrderProductInfoListQuery> orderProductInfoListQueries;

    public static OrderProductInfoBrandQuery toQuery(List<OrderProductInfoListQuery> orderProductInfoListQueries){
        return OrderProductInfoBrandQuery.builder()
                .orderProductInfoListQueries(orderProductInfoListQueries)
                .build();
    }

}
