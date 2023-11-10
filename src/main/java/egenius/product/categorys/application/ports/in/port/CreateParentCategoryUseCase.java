package egenius.product.categorys.application.ports.in.port;

import egenius.product.categorys.application.ports.in.query.CreateParentCategoryQuery;

public interface CreateParentCategoryUseCase {

    void createParentCategory(CreateParentCategoryQuery createParentCategoryQuery);
}
