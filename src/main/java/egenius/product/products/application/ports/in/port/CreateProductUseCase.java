package egenius.product.products.application.ports.in.port;

import egenius.product.products.application.ports.in.query.CreateProductQuery;
import egenius.product.products.application.ports.out.dto.CreateProductDto;

public interface CreateProductUseCase {

    void createProduct(CreateProductQuery createProductQuery);
}
