package egenius.product.VendorProduct.adaptor.web.controller;

import egenius.product.VendorProduct.adaptor.web.request.RequestCreateVendorProduct;
import egenius.product.VendorProduct.adaptor.web.request.RequestUpdateVendorProduct;
import egenius.product.VendorProduct.application.ports.in.port.*;
import egenius.product.VendorProduct.application.ports.in.query.*;
import egenius.product.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vendor-product")
@RequiredArgsConstructor
@Slf4j
public class VendorProductController {

    private final UpdateVendorProductUseCase updateVendorProductUseCase;
    private final GetVendorProductUseCase getVendorProductUseCase;
    private final DeleteVendorProductUseCase deleteVendorProductUseCase;
    private final GetSalesCountUseCase getSalesCountUseCase;

    //재고 변경
    @PostMapping("/inventory")
    public BaseResponse<?> updateVendorProduct(@RequestBody RequestUpdateVendorProduct requestUpdateVendorProduct){
        log.info("상품 정보 변경: {}", requestUpdateVendorProduct);
        updateVendorProductUseCase.updateVendorProduct(UpdateVendorProductQuery.toQuery(
                requestUpdateVendorProduct.getVendorEmail(),
                requestUpdateVendorProduct.getProductDetailId(),
                requestUpdateVendorProduct.getDisplayStatus(),
                requestUpdateVendorProduct.getSalesStatus(),
                requestUpdateVendorProduct.getSalesCount(),
                requestUpdateVendorProduct.getSaveCount()
        ));
        return new BaseResponse<>();
    }

    //재고 조회
    @GetMapping("/vendor-products")
    public BaseResponse<?> getVendorProduct(@RequestHeader("email") String vendorEmail){
        log.info("상품 조회: {}", vendorEmail);
        return new BaseResponse<>(getVendorProductUseCase.getVendorProduct(
                GetVendorProductQuery.toQuery(vendorEmail)));
    }

    // 상품 삭제
    @DeleteMapping("/vendor-products/{productDetailId}")
    public BaseResponse<?> deleteVendorProduct(@RequestHeader("email") String vendorEmail,
                                               @PathVariable(name = "productDetailId") Long productDetailId){
        log.info("상품 삭제: {} {}", vendorEmail, productDetailId);
        deleteVendorProductUseCase.deleteVendorProduct(
                DeleteVendorProductQuery.toQuery(vendorEmail, productDetailId));
        return new BaseResponse<>();
    }

    //장바구니 재고 조회
    @GetMapping("/sales-count/{productDetailId}")
    public BaseResponse<?> getSalesCount(@PathVariable(name = "productDetailId") Long productDetailId){
        log.info("상품 재고 조회: {}", productDetailId);
        return new BaseResponse<>(getSalesCountUseCase.getSalesCount(
                GetSalesCountQuery.toQuery(productDetailId)));
    }

}
