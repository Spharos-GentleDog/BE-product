package egenius.product.products.adaptor.web.controller;

import egenius.product.global.common.response.BaseResponse;
import egenius.product.products.adaptor.web.request.*;
import egenius.product.products.application.ports.in.port.*;
import egenius.product.products.application.ports.in.query.*;
import egenius.product.products.application.ports.out.dto.ProductDetailPageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.io.ResponseOutOfOrderStrategy;
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
    private final OrderProductDetailUseCase orderProductDetailUseCase;
    private final ProductDetailPageUseCase productDetailPageUseCase;
    private final AiServiceProductDetailUseCase aiServiceProductDetailUseCase;
    private final ColorSizeProductDetailUseCase colorSizeProductDetailUseCase;

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

    @PostMapping("/order-product-info")
    public BaseResponse<?> findOrderProductDetail(@RequestBody RequestOrderProductInfoBrand requestOrderProductInfoBrand){
        log.info("주문 상품 상세 조회");

        OrderProductInfoBrandQuery orderProductInfoBrandQuery =
                OrderProductInfoBrandQuery.toQuery(
                requestOrderProductInfoBrand.getRequestOrderProductInfoList().stream()
                .map(requestOrderProductInfoList -> OrderProductInfoListQuery.toQuery(
                        requestOrderProductInfoList.getBrandName(),
                        requestOrderProductInfoList.getRequestOrderProductInfoList().stream()
                                .map(requestOrderProductInfo -> OrderProductInfoQuery.toQuery(
                                                requestOrderProductInfo.getProductDetailId(),
                                                requestOrderProductInfo.getCount()
                                )
                                ).collect(Collectors.toList())
                ))
                .collect(Collectors.toList())
        );

        return new BaseResponse<>(orderProductDetailUseCase.orderProductDetail(orderProductInfoBrandQuery));
    }

    @GetMapping("/product-page")
    public BaseResponse<?> productPageProductDetail(@RequestParam("productId") Long productId){
        log.info("상품 상세 조회");
        return new BaseResponse<>(productDetailPageUseCase.getProductDetailPage(productId));
    }

    @PostMapping("/ai-product-detail")
    public BaseResponse<?> aiServiceFindProductDetailIds(@RequestBody RequestProductIds requestProductIds){

        log.info("상품 상세 조회");

        return new BaseResponse<>(aiServiceProductDetailUseCase.getAiServiceProductDetail(
                AiServiceProductDetailQuery.toQuery(
                        requestProductIds.getProductIds()
                )));
    }

    @PostMapping("/findby-color-size")
    public BaseResponse<?> findProductDetailIds(@RequestBody RequestColorSize requestColorSize){

        log.info("상품 상세 조회");
        return new BaseResponse<>(colorSizeProductDetailUseCase.getColorSizeProductDetail(
                ColorSizeProductDetailQuery.toQuery(
                        requestColorSize.getProductId(),
                        requestColorSize.getColor(),
                        requestColorSize.getSize()
                )));
    }


}
