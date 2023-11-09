package egenius.product.application.categoryports.in.port;

import egenius.product.application.categoryports.in.query.CreateChildCategoryQuery;
import egenius.product.application.categoryports.in.query.CreateParentCategoryQuery;

public interface CreateChildCategoryUseCase {

    void createChildCategory(CreateChildCategoryQuery createChildCategoryQuery);
}
