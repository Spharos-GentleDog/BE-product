package egenius.product.products.application.ports.out.dto;

import egenius.product.products.domain.ImageInfo;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProductDetailPageDto {

    private Long productId; // 상품
    private String productName; // 상품
    private Integer productPrice; // 상품
    private List<ImageInfoDto> ThumnailImgUrl; // 상품 이미지
    private List<ImageInfoDto> ExplainImgUrl; // 상품 상세 이미지
    private String brandName; // 상품
    private String brandLogoUrl; // 상품
    private List<ProductDetailPageOptionsDto> productDetailPageOptionsDto; // 상품 상세
    private List<ColorDto> colorDtoList; //상품 색상
    private List<String> sizeList; // 상품 사이즈
    private Integer totalFavorite; // 상품 좋아요

    public static ProductDetailPageDto formProductDetailPageDto(Long productId, String productName, Integer productPrice,
                                                                List<ImageInfoDto> ThumnailImgUrl, List<ImageInfoDto> ExplainImgUrl,
                                                                String brandName, String brandLogoUrl,
                                                                List<ProductDetailPageOptionsDto> productDetailPageOptionsDto,
                                                                List<ColorDto> colorDtoList, List<String> sizeList,
                                                                Integer totalFavorite){
        return ProductDetailPageDto.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .ThumnailImgUrl(ThumnailImgUrl)
                .ExplainImgUrl(ExplainImgUrl)
                .brandName(brandName)
                .brandLogoUrl(brandLogoUrl)
                .productDetailPageOptionsDto(productDetailPageOptionsDto)
                .colorDtoList(colorDtoList)
                .sizeList(sizeList)
                .totalFavorite(totalFavorite)
                .build();
    }
}
