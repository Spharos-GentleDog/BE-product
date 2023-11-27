package egenius.product.products.application.ports.out.port;

import egenius.product.products.application.ports.in.query.ColorSizeProductDetailQuery;
import egenius.product.products.application.ports.out.dto.ColorSizeProductDetailDto;

public interface ColorSizeProductDetailPort {

    ColorSizeProductDetailDto getColorSizeProductDetail(ColorSizeProductDetailQuery colorSizeProductDetailQuery);
}
