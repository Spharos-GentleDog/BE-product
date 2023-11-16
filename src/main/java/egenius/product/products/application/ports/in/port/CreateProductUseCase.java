package egenius.product.products.application.ports.in.port;

import egenius.product.products.application.ports.in.query.CreateProductQuery;

public interface CreateProductUseCase {

    void createProduct(CreateProductQuery createProductQuery);
}
