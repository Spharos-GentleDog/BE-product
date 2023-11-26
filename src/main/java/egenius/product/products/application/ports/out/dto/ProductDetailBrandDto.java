package egenius.product.products.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProductDetailBrandDto {

    private String brandName;
    private List<ProductDetailDto> productDetailDtoList;

    public static ProductDetailBrandDto formProductDetailBrandDto(String brandName, List<ProductDetailDto> productDetailDtoList){
        return ProductDetailBrandDto.builder()
                .brandName(brandName)
                .productDetailDtoList(productDetailDtoList)
                .build();
    }
}
