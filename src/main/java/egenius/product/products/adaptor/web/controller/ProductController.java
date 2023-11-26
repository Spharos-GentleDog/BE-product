package egenius.product.products.adaptor.web.controller;

import egenius.product.global.common.response.BaseResponse;
import egenius.product.products.adaptor.web.request.RequestBrandProductList;
import egenius.product.products.adaptor.web.request.RequestCreateProduct;
import egenius.product.products.adaptor.web.request.RequestProducts;
import egenius.product.products.application.ports.in.port.CreateProductUseCase;
import egenius.product.products.application.ports.in.port.FindProductDetailUseCase;
import egenius.product.products.application.ports.in.port.FindProductUseCase;
import egenius.product.products.application.ports.in.query.CreateProductQuery;
import egenius.product.products.application.ports.in.query.FindProductDetailQuery;
import egenius.product.products.application.ports.in.query.FindProductListQuery;
import egenius.product.products.application.ports.in.query.FindProductQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final FindProductUseCase findProductUseCase;
    private final FindProductDetailUseCase findProductDetailUseCase;

    @PostMapping("/product-create")
    public BaseResponse<?> productCreate(@RequestBody RequestCreateProduct requestCreateProduct){
        log.info("상품 등록");

        createProductUseCase.createProduct(CreateProductQuery.toQuery(
                requestCreateProduct.getVendorEmail(),
                requestCreateProduct.getProductName(),
                requestCreateProduct.getProductPrice(),
                requestCreateProduct.getBrandName(),
                requestCreateProduct.getBrandLogoUrl(),
                requestCreateProduct.getCategoryName(),
                requestCreateProduct.getSizeName(),
                requestCreateProduct.getColorName(),
                requestCreateProduct.getMainImageUrl(),
                requestCreateProduct.getThumbnailsImageUrl(),
                requestCreateProduct.getExplainImageUrl())
        );

        return new BaseResponse<>();

    }

    @GetMapping("/product-find")
    public BaseResponse<?> productFind(@RequestParam("categoryType") String categoryType,
                                       @RequestParam(value = "CategoryId", required = false) Integer CategoryId,
//                                       @RequestParam("sizeName") String sizeName,
//                                       @RequestParam("colorName") String colorName,
//                                       @RequestParam("productType") String productType,
//                                       @RequestParam("minPrice") Integer minPrice,
//                                       @RequestParam("maxPrice") Integer maxPrice,
                                       @RequestParam("isDiscount") Boolean isDiscount,
                                       @RequestParam("page") Integer page){

        log.info("상품 조회");


        return new BaseResponse<>(findProductUseCase.findProduct(
                FindProductQuery.toQuery(
                categoryType,
                CategoryId,
//                sizeName,
//                colorName,
//                productType,
//                minPrice,
//                maxPrice,
                isDiscount,
                page
        )));
    }

    @PostMapping("/find-product-detail")
    public BaseResponse<?> findProductDetail(@RequestBody RequestBrandProductList requestBrandProductList){
        log.info("상품 상세 조회");

        FindProductListQuery findProductListQuery =
                FindProductListQuery.toQuery(
                        requestBrandProductList.getRequestProductsList().stream()
                                .map(requestProducts -> FindProductDetailQuery.toQuery(
                                        requestProducts.getBrandName(),
                                        requestProducts.getProductDetailIds()
                                ))
                                .collect(Collectors.toList()));

        return new BaseResponse<>(findProductDetailUseCase.findProductDetail(findProductListQuery));
    }


}
