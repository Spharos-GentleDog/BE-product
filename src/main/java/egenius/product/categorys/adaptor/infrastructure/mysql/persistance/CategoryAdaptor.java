package egenius.product.categorys.adaptor.infrastructure.mysql.persistance;

import egenius.product.categorys.adaptor.infrastructure.mysql.entity.ProductCategoryEntity;
import egenius.product.categorys.adaptor.infrastructure.mysql.repository.CategoryRepository;
import egenius.product.categorys.application.ports.out.dto.ParentCategoryDto;
import egenius.product.categorys.application.ports.out.dto.ReadChildCategoryCountDto;
import egenius.product.categorys.application.ports.out.dto.ReadChildCategoryDto;
import egenius.product.categorys.application.ports.out.dto.ReadParentCategoryDto;
import egenius.product.categorys.application.ports.out.port.*;
import egenius.product.categorys.domain.Categorys;
import egenius.product.global.common.exception.BaseException;
import egenius.product.global.common.response.BaseResponseStatus;
import egenius.product.products.adaptor.infrastructure.mysql.repository.ProductCategoryListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class CategoryAdaptor implements CreateParentCategoryPort, CreateChildCategoryPort, FindParentCategoryNamePort,
        ReadParentCategoryPort, ReadChildCategoryPort, ReadChildCategoryCountPort {

    private final CategoryRepository categoryRepository;
    private final ProductCategoryListRepository productCategoryListRepository;


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

    @Override
    public List<ReadChildCategoryDto> readChildCategory(Categorys categorys) {

        Optional<ProductCategoryEntity> parentCategoryEntity =
                categoryRepository.findByCategoryName(categorys.getParentCategory());

        if(parentCategoryEntity.isEmpty()){
            throw new BaseException(BaseResponseStatus.NOT_FOUND_CATEGORY);
        }

        List<ProductCategoryEntity> productCategoryEntityList =
                categoryRepository.findByParentCategory(parentCategoryEntity.get());

        if(productCategoryEntityList.isEmpty()){
            throw new BaseException(BaseResponseStatus.NOT_FOUND_CHILD_CATEGORY);
        }

        List<ReadChildCategoryDto> readChildCategoryDtoList =
                productCategoryEntityList.stream()
                        .map(productCategoryEntity -> ReadChildCategoryDto.fromChildCategory(
                                productCategoryEntity.getId(),
                                productCategoryEntity.getCategoryName()
                        ))
                        .toList();

        return readChildCategoryDtoList;
    }

    @Override
    public List<ReadChildCategoryCountDto> readChildCategoryCount(Categorys categorys) {

        Optional<ProductCategoryEntity> parentCategoryEntity =
                categoryRepository.findByCategoryName(categorys.getParentCategory());

        if(parentCategoryEntity.isEmpty()){
            throw new BaseException(BaseResponseStatus.NOT_FOUND_CATEGORY);
        }

        List<ProductCategoryEntity> productCategoryEntityList =
                categoryRepository.findByParentCategory(parentCategoryEntity.get());

        if(productCategoryEntityList.isEmpty()){
            throw new BaseException(BaseResponseStatus.NOT_FOUND_CHILD_CATEGORY);
        }

        List<ReadChildCategoryCountDto> readChildCategoryCountDtoList =
                productCategoryEntityList.stream()
                        .map(productCategoryEntity -> {

                            Integer count = productCategoryListRepository.findByCategoryId(productCategoryEntity);
                            log.info("count : {}",count);
                            return ReadChildCategoryCountDto.fromChildCategory(
                                    productCategoryEntity.getId(),
                                    productCategoryEntity.getCategoryName(),
                                    count
                            );

                        })
                        .toList();

        return readChildCategoryCountDtoList;
    }
}
