package egenius.product.sizes.application.ports.in.port;

import egenius.product.sizes.application.ports.in.query.CreateSizesQuery;

public interface CreateSizesUseCase {

    void createSize(CreateSizesQuery createSizesQuery);
}
