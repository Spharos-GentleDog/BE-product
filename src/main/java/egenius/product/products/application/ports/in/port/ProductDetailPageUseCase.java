package egenius.product.products.application.ports.in.port;

import egenius.product.products.application.ports.out.dto.ProductDetailPageDto;

public interface ProductDetailPageUseCase {

    ProductDetailPageDto getProductDetailPage(Long productId);
}
