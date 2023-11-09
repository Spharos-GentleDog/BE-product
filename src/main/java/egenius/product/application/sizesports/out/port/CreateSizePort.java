package egenius.product.application.sizesports.out.port;

import egenius.product.application.sizesports.out.dto.CreateSizeDto;
import egenius.product.domain.Sizes;


public interface CreateSizePort {

    CreateSizeDto createSize(Sizes sizes);
}
