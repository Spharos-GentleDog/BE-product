package egenius.product.categorys.application.ports.out.port;

import egenius.product.categorys.application.ports.out.dto.ReadChildCategoryCountDto;
import egenius.product.categorys.domain.Categorys;

import java.util.List;

public interface ReadChildCategoryCountPort {

    List<ReadChildCategoryCountDto> readChildCategoryCount(Categorys categorys);
}
