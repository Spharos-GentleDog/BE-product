package egenius.product.products.application.ports.out.port;

import egenius.product.products.application.ports.in.query.FindProductDetailQuery;
import egenius.product.products.application.ports.in.query.FindProductListQuery;
import egenius.product.products.application.ports.out.dto.FindProductDetailDto;
import egenius.product.products.application.ports.out.dto.ProductDetailBrandDto;

public interface FindProductDetailPort {

    FindProductDetailDto findProductDetail(FindProductListQuery findProductListQuery);
}
