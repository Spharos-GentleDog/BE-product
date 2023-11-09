package egenius.product.application.service;

import egenius.product.application.categoryports.in.port.CreateChildCategoryUseCase;
import egenius.product.application.categoryports.in.port.CreateParentCategoryUseCase;
import egenius.product.application.categoryports.in.port.ReadParentCategoryUseCase;
import egenius.product.application.categoryports.in.query.CreateChildCategoryQuery;
import egenius.product.application.categoryports.in.query.CreateParentCategoryQuery;
import egenius.product.application.categoryports.out.dto.ReadParentCategoryDto;
import egenius.product.application.categoryports.out.port.CreateChildCategoryPort;
import egenius.product.application.categoryports.out.port.CreateParentCategoryPort;
import egenius.product.application.categoryports.out.port.FindParentCategoryNamePort;
import egenius.product.application.categoryports.out.port.ReadParentCategoryPort;
import egenius.product.domain.Categorys;
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
