package egenius.product.products.application.ports.in.port;

import egenius.product.products.application.ports.out.dto.FindProductDetailDto;

public interface FindProductDetail {

    FindProductDetailDto findProductDetail(Long productId);
}
