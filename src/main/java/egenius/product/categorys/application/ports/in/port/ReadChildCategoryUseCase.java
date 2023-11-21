package egenius.product.categorys.application.ports.in.port;

import egenius.product.categorys.application.ports.in.query.ReadChildCategoryQuery;
import egenius.product.categorys.application.ports.out.dto.ReadChildCategoryDto;

import java.util.List;

public interface ReadChildCategoryUseCase {

    List<ReadChildCategoryDto> readChildCategory(ReadChildCategoryQuery readChildCategoryQuery);
}
