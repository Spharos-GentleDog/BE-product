package egenius.product.products.application.ports.in.query;

import egenius.product.products.domain.ImageInfo;
import egenius.product.products.domain.ProductDetails;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CreateProductQuery {

    //상품 개별 금액, 할인률 설정하지 않고 한번에 설정 하는 경우

    private String productName; // 상품명
    private Integer productPrice; // 상품 가격 (상품별 가격 다 따로 받는 경우 금액도 리스트로 받아야 함)
    private String brandName; // 브랜드명
    private String brandLogoUrl; // 브랜드 로고 URL
    private List<String> categoryName; // 카테고리명
    private List<String> sizeName; // 사이즈명들
    private List<String> colorName; // 컬러명들
    private ImageInfo MainImageUrl; // 메인 이미지 Url
    private List<ImageInfo> ThumbnailsImageUrl; // 썸네일Url들
    private List<ImageInfo> explainImageUrl; // 설명 이미지 Url들

    public static CreateProductQuery toQuery(String productName, Integer productPrice, String brandName,
                                             String brandLogoUrl, List<String> categoryName,
                                             List<String> sizeName, List<String> colorName,
                                             ImageInfo MainImageUrl, List<ImageInfo> ThumbnailsImageUrl,
                                             List<ImageInfo> explainImageUrl){
        return CreateProductQuery.builder()
                .productName(productName)
                .productPrice(productPrice)
                .brandName(brandName)
                .brandLogoUrl(brandLogoUrl)
                .categoryName(categoryName)
                .sizeName(sizeName)
                .colorName(colorName)
                .MainImageUrl(MainImageUrl)
                .ThumbnailsImageUrl(ThumbnailsImageUrl)
                .explainImageUrl(explainImageUrl)
                .build();
    }
}
