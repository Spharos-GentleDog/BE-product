package egenius.product.products.application.ports.in.query;

import egenius.product.products.adaptor.web.request.RequestProducts;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FindProductListQuery {

    private List<FindProductDetailQuery> findProductDetailQueryList;

    public static FindProductListQuery toQuery(List<FindProductDetailQuery> findProductDetailQueryList){
        return FindProductListQuery.builder()
                .findProductDetailQueryList(findProductDetailQueryList)
                .build();
    }

}
