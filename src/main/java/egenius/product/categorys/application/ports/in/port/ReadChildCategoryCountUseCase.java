package egenius.product.categorys.application.ports.in.port;

import egenius.product.categorys.application.ports.in.query.ReadChildCategoryCountQuery;
import egenius.product.categorys.application.ports.out.dto.ReadChildCategoryCountDto;

import java.util.List;

public interface ReadChildCategoryCountUseCase {

    List<ReadChildCategoryCountDto> readChildCategoryCount(ReadChildCategoryCountQuery readChildCategoryCountQuery);
}
