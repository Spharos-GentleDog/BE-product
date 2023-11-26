package egenius.product.products.application.ports.in.port;

import egenius.product.products.application.ports.in.query.OrderProductInfoBrandQuery;
import egenius.product.products.application.ports.out.dto.OrderProductInfoBrandDto;

public interface OrderProductDetailUseCase {

    OrderProductInfoBrandDto orderProductDetail(OrderProductInfoBrandQuery orderProductInfoBrandQuery);

}
