package egenius.product.products.application.ports.in.port;

import egenius.product.products.application.ports.in.query.FindProductQuery;
import egenius.product.products.application.ports.out.dto.FindProductDto;

import java.util.List;

public interface FindProductUseCase {

    List<FindProductDto> findProduct(FindProductQuery findProductQuery);
}
