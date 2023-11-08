package egenius.product.application.sizeports.in.port;

import egenius.product.application.sizeports.in.query.CreateSizesQuery;
import egenius.product.application.sizeports.out.dto.CreateSizeDto;

public interface CreateSizesUseCase {

    CreateSizeDto createSize(CreateSizesQuery createSizesQuery);
}
