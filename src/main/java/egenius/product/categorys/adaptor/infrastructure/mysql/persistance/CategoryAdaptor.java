package egenius.product.categorys.adaptor.infrastructure.mysql.persistance;

import egenius.product.categorys.adaptor.infrastructure.mysql.entity.ProductCategoryEntity;
import egenius.product.categorys.adaptor.infrastructure.mysql.repository.CategoryRepository;
import egenius.product.categorys.application.ports.out.dto.ParentCategoryDto;
import egenius.product.categorys.application.ports.out.dto.ReadParentCategoryDto;
import egenius.product.categorys.application.ports.out.port.CreateChildCategoryPort;
import egenius.product.categorys.application.ports.out.port.CreateParentCategoryPort;
import egenius.product.categorys.application.ports.out.port.FindParentCategoryNamePort;
import egenius.product.categorys.application.ports.out.port.ReadParentCategoryPort;
import egenius.product.categorys.domain.Categorys;
import egenius.product.global.common.exception.BaseException;
import egenius.product.global.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class CategoryAdaptor implements CreateParentCategoryPort, CreateChildCategoryPort, FindParentCategoryNamePort,
        ReadParentCategoryPort {

    private final CategoryRepository categoryRepository;


    @Override
    public void createParentCategory(Categorys categorys) {

        ProductCategoryEntity productCategoryEntity = ProductCategoryEntity.createParentCategory(
                categorys.getCategoryName());


        categoryRepository.save(productCategoryEntity);
    }

    @Override
    public void CreateChildCategory(Categorys categorys) {

        Optional<ProductCategoryEntity> parentCategoryEntity =
                categoryRepository.findByCategoryName(categorys.getParentCategory());


        if(parentCategoryEntity.isEmpty()){
            throw new BaseException(BaseResponseStatus.NOT_FOUND_CATEGORY);
        }

        ProductCategoryEntity productCategoryEntity = ProductCategoryEntity.createChildCategory(
                categorys.getCategoryName(),
                parentCategoryEntity.get()
        );

        categoryRepository.save(productCategoryEntity);
    }

    @Override
    public String findParentCategoryName(Integer parentCategoryName) {

        Optional<ProductCategoryEntity> productCategoryEntityName =
                categoryRepository.findById(parentCategoryName);

        if(productCategoryEntityName.isEmpty()){
            throw new BaseException(BaseResponseStatus.NOT_FOUND_CATEGORY);
        }

        return productCategoryEntityName.get().getCategoryName();
    }

    @Override
    public ReadParentCategoryDto readParentCategory() {

        List<ProductCategoryEntity> productCategoryEntityList
                = categoryRepository.findByParentCategoryIsNull();


        List<ParentCategoryDto> parentCategoryDtoList =
                productCategoryEntityList.stream()
                        .map(productCategoryEntity -> ParentCategoryDto.fromParentCategoryDto(
                                productCategoryEntity.getId(),
                                productCategoryEntity.getCategoryName()
                        ))
                        .toList();

        return ReadParentCategoryDto.formReadParentCategoryDto(parentCategoryDtoList);
    }
}
