package egenius.product.products.application.service;

import egenius.product.products.application.ports.in.port.*;
import egenius.product.products.application.ports.in.query.*;
import egenius.product.products.application.ports.out.dto.*;
import egenius.product.products.application.ports.out.port.*;
import egenius.product.products.domain.Products;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements CreateProductUseCase, FindProductUseCase, FindProductDetailUseCase,
        OrderProductDetailUseCase, ProductDetailPageUseCase, AiServiceProductDetailUseCase{

    private final CreateProductPort createProductPort;
    private final FindProductPort findProductPort;
    private final FindProductDetailPort findProductDetailPort;
    private final OrderProductInfoPort orderProductInfoPort;
    private final ProductDetailPagePort productDetailPagePort;
    private final AiServiceProductDetailPort aiServiceProductDetailPort;

    @Override
    public void createProduct(CreateProductQuery createProductQuery) {

        // 상품 코드 생성 (브랜드명 2글자 + 상품명 2글자 + 랜덤 숫자)
        String productCode = (createProductQuery.getBrandName().length() >= 2 ?
                createProductQuery.getBrandName().substring(0,2) : createProductQuery.getBrandName())
                + (createProductQuery.getProductName().length() >= 2 ?
                createProductQuery.getProductName().substring(0,2)
                : createProductQuery.getProductName()) + (int)(Math.random() * 10000);

        createProductPort.createProduct(Products.createProduct(
            createProductQuery.getVendorEmail(),
            createProductQuery.getProductName(),
            productCode,
            createProductQuery.getProductPrice(),
            createProductQuery.getBrandName(),
            createProductQuery.getBrandLogoUrl(),
            createProductQuery.getCategoryName(),
            createProductQuery.getSizeName(),
            createProductQuery.getColorName(),
            createProductQuery.getMainImageUrl(),
            createProductQuery.getThumbnailsImageUrl(),
            createProductQuery.getExplainImageUrl(),
            0
        ));

    }

    @Override
    public List<FindProductDto> findProduct(FindProductQuery findProductQuery) {
        return findProductPort.findProduct(findProductQuery);
    }

    @Override
    public FindProductDetailDto findProductDetail(FindProductListQuery findProductListQuery) {
        return findProductDetailPort.findProductDetail(findProductListQuery);
    }

    @Override
    public OrderProductInfoBrandDto orderProductDetail(OrderProductInfoBrandQuery orderProductInfoBrandQuery) {
        return orderProductInfoPort.orderProductInfo(orderProductInfoBrandQuery);
    }

    @Override
    public ProductDetailPageDto getProductDetailPage(Long productId) {
        return productDetailPagePort.getProductDetailPage(productId);
    }

    @Override
    public List<AiServiceProductResultDto>  getAiServiceProductDetail(AiServiceProductDetailQuery aiServiceProductDetailQuery) {
        return aiServiceProductDetailPort.formAiServiceProductDetail(aiServiceProductDetailQuery);
    }
}
