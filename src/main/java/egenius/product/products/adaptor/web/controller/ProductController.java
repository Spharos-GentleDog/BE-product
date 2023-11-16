package egenius.product.products.adaptor.web.controller;

import egenius.product.global.common.response.BaseResponse;
import egenius.product.products.adaptor.web.request.RequestCreateProduct;
import egenius.product.products.application.ports.in.port.CreateProductUseCase;
import egenius.product.products.application.ports.in.query.CreateProductQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final CreateProductUseCase createProductUseCase;

    @PostMapping("/product-create")
    public BaseResponse<?> productCreate(@RequestBody RequestCreateProduct requestCreateProduct){
        log.info("상품 등록");
        return new BaseResponse<>(createProductUseCase.createProduct(CreateProductQuery.toQuery(
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
                requestCreateProduct.getExplainImageUrl())));

    }


}
