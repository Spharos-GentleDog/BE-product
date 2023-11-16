package egenius.product.categorys.application.service;

import egenius.product.categorys.application.ports.in.port.CreateChildCategoryUseCase;
import egenius.product.categorys.application.ports.in.port.CreateParentCategoryUseCase;
import egenius.product.categorys.application.ports.in.port.ReadParentCategoryUseCase;
import egenius.product.categorys.application.ports.in.query.CreateChildCategoryQuery;
import egenius.product.categorys.application.ports.in.query.CreateParentCategoryQuery;
import egenius.product.categorys.application.ports.out.dto.ReadParentCategoryDto;
import egenius.product.categorys.application.ports.out.port.CreateChildCategoryPort;
import egenius.product.categorys.application.ports.out.port.CreateParentCategoryPort;
import egenius.product.categorys.application.ports.out.port.FindParentCategoryNamePort;
import egenius.product.categorys.application.ports.out.port.ReadParentCategoryPort;
import egenius.product.categorys.domain.Categorys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService implements CreateParentCategoryUseCase, CreateChildCategoryUseCase, ReadParentCategoryUseCase {

    private final CreateParentCategoryPort createParentCategoryPort;
    private final FindParentCategoryNamePort findParentCategoryNamePort;
    private final CreateChildCategoryPort createChildCategoryPort;
    private final ReadParentCategoryPort readParentCategoryPort;

    @Override
    public void createParentCategory(CreateParentCategoryQuery createParentCategoryQuery) {

        Categorys categorys = Categorys.createParentCategory(createParentCategoryQuery.getCategoryName());

        createParentCategoryPort.createParentCategory(categorys);

    }

    @Override
    public void createChildCategory(CreateChildCategoryQuery createChildCategoryQuery) {

        String parentCategoryName = findParentCategoryNamePort.findParentCategoryName(
                createChildCategoryQuery.getParentCategoryId());

        log.info("부모 카테고리 이름 : {}",parentCategoryName);
        Categorys categorys = Categorys.createChildCategory(
                createChildCategoryQuery.getChildCategoryName(),
                parentCategoryName

        );

        createChildCategoryPort.CreateChildCategory(categorys);
    }


    @Override
    public ReadParentCategoryDto readParentCategory() {

        return readParentCategoryPort.readParentCategory();
    }
}
