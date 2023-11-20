package egenius.product.categorys.application.service;

import egenius.product.categorys.application.ports.in.port.*;
import egenius.product.categorys.application.ports.in.query.CreateChildCategoryQuery;
import egenius.product.categorys.application.ports.in.query.CreateParentCategoryQuery;
import egenius.product.categorys.application.ports.in.query.ReadChildCategoryCountQuery;
import egenius.product.categorys.application.ports.in.query.ReadChildCategoryQuery;
import egenius.product.categorys.application.ports.out.dto.ReadChildCategoryCountDto;
import egenius.product.categorys.application.ports.out.dto.ReadChildCategoryDto;
import egenius.product.categorys.application.ports.out.dto.ReadParentCategoryDto;
import egenius.product.categorys.application.ports.out.port.*;
import egenius.product.categorys.domain.Categorys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService implements CreateParentCategoryUseCase, CreateChildCategoryUseCase,
        ReadParentCategoryUseCase, ReadChildCategoryUseCase, ReadChildCategoryCountUseCase {

    private final CreateParentCategoryPort createParentCategoryPort;
    private final FindParentCategoryNamePort findParentCategoryNamePort;
    private final CreateChildCategoryPort createChildCategoryPort;
    private final ReadParentCategoryPort readParentCategoryPort;
    private final ReadChildCategoryPort readChildCategoryPort;
    private final ReadChildCategoryCountPort readChildCategoryCountPort;

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

    @Override
    public List<ReadChildCategoryDto> readChildCategory(ReadChildCategoryQuery readChildCategoryQuery) {

        String parentCategoryName = findParentCategoryNamePort.findParentCategoryName(
                readChildCategoryQuery.getParentCategoryId());


        return readChildCategoryPort.readChildCategory(
                Categorys.readChildCategory(parentCategoryName)
        );
    }

    @Override
    public List<ReadChildCategoryCountDto> readChildCategoryCount(
            ReadChildCategoryCountQuery readChildCategoryCountQuery) {

        String parentCategoryName = findParentCategoryNamePort.findParentCategoryName(
                readChildCategoryCountQuery.getParentCategoryId());

        return readChildCategoryCountPort.readChildCategoryCount(
                Categorys.readChildCategoryCount(parentCategoryName)
        );

    }
}
