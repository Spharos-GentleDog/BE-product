package egenius.product.adaptor.web.controller;

import egenius.product.adaptor.web.request.CreateChildCategoryRequest;
import egenius.product.adaptor.web.request.CreateParentCategoryRequest;
import egenius.product.application.categoryports.in.port.CreateChildCategoryUseCase;
import egenius.product.application.categoryports.in.port.CreateParentCategoryUseCase;
import egenius.product.application.categoryports.in.port.ReadParentCategoryUseCase;
import egenius.product.application.categoryports.in.query.CreateChildCategoryQuery;
import egenius.product.application.categoryports.in.query.CreateParentCategoryQuery;
import egenius.product.application.categoryports.out.dto.ReadParentCategoryDto;
import egenius.product.application.categoryports.out.port.CreateParentCategoryPort;
import egenius.product.application.colorports.out.dto.ReadColorsDto;
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

}
