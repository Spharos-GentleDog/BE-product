package egenius.product.categorys.application.ports.out.port;

import egenius.product.categorys.application.ports.out.dto.ReadChildCategoryDto;
import egenius.product.categorys.domain.Categorys;

import java.util.List;

public interface ReadChildCategoryPort {

    List<ReadChildCategoryDto> readChildCategory(Categorys categorys);
}
