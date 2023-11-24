package egenius.product.products.application.service;

import egenius.product.products.application.ports.in.port.CreateProductUseCase;
import egenius.product.products.application.ports.in.port.FindProductUseCase;
import egenius.product.products.application.ports.in.query.CreateProductQuery;
import egenius.product.products.application.ports.in.query.FindProductQuery;
import egenius.product.products.application.ports.out.dto.CreateProductDto;
import egenius.product.products.application.ports.out.dto.FindProductDto;
import egenius.product.products.application.ports.out.port.CreateProductPort;
import egenius.product.products.application.ports.out.port.FindProductPort;
import egenius.product.products.domain.ProductDetails;
import egenius.product.products.domain.Products;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements CreateProductUseCase, FindProductUseCase {

    private final CreateProductPort createProductPort;
    private final FindProductPort findProductPort;

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
}
