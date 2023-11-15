package egenius.product.products.domain;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Products {

    private String productCode; // 상품 코드
    private String productName; // 상품명
    private String brandName; // 브랜드명
    private String brandLogoUrl; // 브랜드 로고 URL
    private Integer totalFavorite; // 총 찜 수
    private List<String> categoryName; // 카테고리명
    private List<String> sizeName; // 사이즈명
    private List<String> colorName; // 컬러명
    private List<ProductDetails> productDetail; // 세부 상품들
    private List<String> ThumbnailsImageUrl; // 썸네일Url
    private List<String> explainImageUrl; // 설명 이미지 Url
    private String vendorEmail; // 판매자 정보 (이메일)
    private String salesStatus; // 판매 상태 (0: 판매중, 1: 품절, 2: 판매중지)
    private Integer salesCount; // 재고 수량
    private Integer saveCount; // 안심 재고 수량

    // 상품 생성
    public static Products createProduct(String productCode, String productName, String brandName,
                                         String brandLogoUrl, Integer totalFavorite, List<String> categoryName,
                                         List<String> sizeName, List<String> colorName,
                                         List<ProductDetails> productDetail, List<String> ThumbnailsImageUrl,
                                         List<String> explainImageUrl, String vendorEmail, String salesStatus,
                                         Integer salesCount, Integer saveCount){
        return Products.builder()
                .productCode(productCode)
                .productName(productName)
                .brandName(brandName)
                .brandLogoUrl(brandLogoUrl)
                .totalFavorite(totalFavorite)
                .categoryName(categoryName)
                .sizeName(sizeName)
                .colorName(colorName)
                .productDetail(productDetail)
                .ThumbnailsImageUrl(ThumbnailsImageUrl)
                .explainImageUrl(explainImageUrl)
                .vendorEmail(vendorEmail)
                .salesStatus(salesStatus)
                .salesCount(salesCount)
                .saveCount(saveCount)
                .build();
    }


}
