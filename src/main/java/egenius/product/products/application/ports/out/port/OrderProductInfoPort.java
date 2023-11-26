package egenius.product.products.application.ports.out.port;

import egenius.product.products.application.ports.in.query.OrderProductInfoBrandQuery;
import egenius.product.products.application.ports.out.dto.OrderProductInfoBrandDto;

public interface OrderProductInfoPort {

    OrderProductInfoBrandDto orderProductInfo(OrderProductInfoBrandQuery orderProductInfoBrandQuery);
}
