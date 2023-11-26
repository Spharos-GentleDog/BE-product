package egenius.product.products.application.ports.in.port;

import egenius.product.products.application.ports.in.query.FindProductDetailQuery;
import egenius.product.products.application.ports.in.query.FindProductListQuery;
import egenius.product.products.application.ports.out.dto.FindProductDetailDto;
import egenius.product.products.application.ports.out.dto.ProductDetailBrandDto;

import java.util.List;

public interface FindProductDetailUseCase {

    FindProductDetailDto findProductDetail(FindProductListQuery findProductListQuery);
}
