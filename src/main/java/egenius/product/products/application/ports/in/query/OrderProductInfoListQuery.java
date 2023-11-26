package egenius.product.products.application.ports.in.query;

import egenius.product.products.adaptor.web.request.RequestOrderProductInfo;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OrderProductInfoListQuery {

    private String brandName;
    private List<OrderProductInfoQuery> orderProductInfoQueries;

    public static OrderProductInfoListQuery toQuery(String brandName, List<OrderProductInfoQuery> orderProductInfoQueries) {
        return OrderProductInfoListQuery.builder()
                .brandName(brandName)
                .orderProductInfoQueries(orderProductInfoQueries)
                .build();
    }

}
