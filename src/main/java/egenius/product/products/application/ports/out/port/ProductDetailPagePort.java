package egenius.product.products.application.ports.out.port;

import egenius.product.products.application.ports.out.dto.ProductDetailPageDto;

public interface ProductDetailPagePort {

    ProductDetailPageDto getProductDetailPage(Long productId);
}
