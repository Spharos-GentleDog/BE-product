package egenius.product.categorys.application.ports.in.port;

import egenius.product.categorys.application.ports.in.query.CreateChildCategoryQuery;

public interface CreateChildCategoryUseCase {

    void createChildCategory(CreateChildCategoryQuery createChildCategoryQuery);
}
