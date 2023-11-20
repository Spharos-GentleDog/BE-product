package egenius.product.products.application.ports.out.port;

import egenius.product.products.application.ports.out.dto.CreateProductDto;
import egenius.product.products.domain.Products;

public interface CreateProductPort {

    void createProduct(Products products);
}
