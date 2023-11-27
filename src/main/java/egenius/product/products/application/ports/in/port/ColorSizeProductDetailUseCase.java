package egenius.product.products.application.ports.in.port;

import egenius.product.products.application.ports.in.query.ColorSizeProductDetailQuery;
import egenius.product.products.application.ports.out.dto.ColorSizeProductDetailDto;

public interface ColorSizeProductDetailUseCase {

    ColorSizeProductDetailDto getColorSizeProductDetail(ColorSizeProductDetailQuery colorSizeProductDetailQuery);
}
