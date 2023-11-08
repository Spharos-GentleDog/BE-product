package egenius.product.application.sizeports.out.port;

import egenius.product.application.sizeports.out.dto.CreateSizeDto;
import egenius.product.domain.Sizes;


public interface CreateSizePort {

    CreateSizeDto createSize(Sizes sizes);
}
