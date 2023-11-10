package egenius.product.categorys.application.ports.out.port;

import egenius.product.categorys.domain.Categorys;

public interface CreateParentCategoryPort {

    void createParentCategory(Categorys categorys);
}
