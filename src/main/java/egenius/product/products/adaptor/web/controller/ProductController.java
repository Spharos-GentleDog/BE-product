package egenius.product.products.adaptor.web.controller;

import egenius.product.products.adaptor.web.request.RequestCreateProduct;
import egenius.product.products.application.ports.in.port.CreateProductUseCase;
import egenius.product.products.application.ports.in.query.CreateProductQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vendor")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final CreateProductUseCase createProductUseCase;

    @PostMapping("/product-create")
    public void productCreate(@RequestBody RequestCreateProduct requestCreateProduct){
        log.info("상품 등록");
        createProductUseCase.createProduct(CreateProductQuery.toQuery(
                requestCreateProduct.getProductName(),
                requestCreateProduct.getProductPrice(),
                requestCreateProduct.getBrandName(),
                requestCreateProduct.getBrandLogoUrl(),
                requestCreateProduct.getCategoryName(),
                requestCreateProduct.getSizeName(),
                requestCreateProduct.getColorName(),
                requestCreateProduct.getMainImageUrl(),
                requestCreateProduct.getThumbnailsImageUrl(),
                requestCreateProduct.getExplainImageUrl()));


    }


}
