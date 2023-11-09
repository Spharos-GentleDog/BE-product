package egenius.product.application.categoryports.in.port;

import egenius.product.application.categoryports.in.query.CreateParentCategoryQuery;

public interface CreateParentCategoryUseCase {

    void createParentCategory(CreateParentCategoryQuery createParentCategoryQuery);
}
