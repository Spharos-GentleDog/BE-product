package egenius.product.categorys.adaptor.web.controller;

import egenius.product.categorys.adaptor.web.request.CreateChildCategoryRequest;
import egenius.product.categorys.adaptor.web.request.CreateParentCategoryRequest;
import egenius.product.categorys.application.ports.in.port.*;
import egenius.product.categorys.application.ports.in.query.CreateChildCategoryQuery;
import egenius.product.categorys.application.ports.in.query.CreateParentCategoryQuery;
import egenius.product.categorys.application.ports.in.query.ReadChildCategoryCountQuery;
import egenius.product.categorys.application.ports.in.query.ReadChildCategoryQuery;
import egenius.product.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CreateParentCategoryUseCase createParentCategoryUseCase;
    private final CreateChildCategoryUseCase createChildCategoryUseCase;
    private final ReadParentCategoryUseCase readParentCategoryUseCase;
    private final ReadChildCategoryUseCase readChildCategoryUseCase;
    private final ReadChildCategoryCountUseCase readChildCategoryCountUseCase;

    @PostMapping("/create-parent-category")
    public BaseResponse<?> createParentCategory(@RequestBody CreateParentCategoryRequest createParentCategoryRequest){

        log.info("부모 카테고리 생성");
        createParentCategoryUseCase.createParentCategory(CreateParentCategoryQuery.toQuery(
                createParentCategoryRequest.getCategoryName()));

        return new BaseResponse<>();
    }

    @PostMapping("/create-child-category")
    public BaseResponse<?> createChildCategory(@RequestBody CreateChildCategoryRequest createChildCategoryRequest){

        log.info("자식 카테고리 생성");
        createChildCategoryUseCase.createChildCategory(CreateChildCategoryQuery.toQuery(
                createChildCategoryRequest.getParentCategoryId(),
                createChildCategoryRequest.getChildCategoryName()
        ));

        return new BaseResponse<>();
    }

    @GetMapping("/read-parent-category")
    public BaseResponse<?> readParentCategory(){

        log.info("부모 카테고리 조회");
        return new BaseResponse<>(readParentCategoryUseCase.readParentCategory());
    }

    @GetMapping("/read-child-category")
    public BaseResponse<?> readChildCategory(@RequestParam(name = "parentCategoryId") Integer parentCategoryId){

        log.info("자식 카테고리 조회:{}",parentCategoryId );
        return new BaseResponse<>(readChildCategoryUseCase.readChildCategory(ReadChildCategoryQuery.toQuery(
                parentCategoryId
        )));
    }

    @GetMapping("/read-child-category-count")
    public BaseResponse<?> readChildCategoryCount(@RequestParam(name = "parentCategoryId") Integer parentCategoryId){

        log.info("자식 카테고리 조회:{}",parentCategoryId );
        return new BaseResponse<>(readChildCategoryCountUseCase.readChildCategoryCount(
                ReadChildCategoryCountQuery.toQuery(
                parentCategoryId
        )));
    }

}
