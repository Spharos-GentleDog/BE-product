package egenius.product.products.domain;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Products {

    private String vendorEmail; // 판매자 ID
    private String productName; // 상품명
    private String productCode; // 상품 코드
    private Integer productPrice; // 상품 가격
    private String brandName; // 브랜드명
    private String brandLogoUrl; // 브랜드 로고 URL
    private List<String> categoryName; // 카테고리명
    private List<String> sizeName; // 사이즈명
    private List<String> colorName; // 컬러명
    private List<ProductDetails> productDetail; // 세부 상품들
    private ImageInfo MainImageUrl; // 메인 이미지 Url
    private List<ImageInfo> ThumbnailsImageUrl; // 썸네일Url
    private List<ImageInfo> explainImageUrl; // 설명 이미지 Url
    private Integer totalFavorite; // 총 좋아요 수
//    private String vendorEmail; // 판매자 정보 (이메일) 다른 서버 (kafka 적용 필요)
//    private String salesStatus; // 판매 상태 (0: 판매중, 1: 품절, 2: 판매중지) 다른 서버 (kafka 적용 필요)
//    private Integer salesCount; // 재고 수량 다른 서버 (kafka 적용 필요)
//    private Integer saveCount; // 안심 재고 수량 다른 서버 (kafka 적용 필요)

    // 상품 생성- kafka 미 적용
    public static Products createProduct(String vendorEmail, String productName, String productCode, Integer productPrice,
                                         String brandName, String brandLogoUrl, List<String> categoryName,
                                         List<String> sizeName, List<String> colorName,
                                         ImageInfo MainImageUrl, List<ImageInfo> ThumbnailsImageUrl,
                                         List<ImageInfo> explainImageUrl, Integer totalFavorite) {
        return Products.builder()
                .vendorEmail(vendorEmail)
                .productName(productName)
                .productCode(productCode)
                .productPrice(productPrice)
                .brandName(brandName)
                .brandLogoUrl(brandLogoUrl)
                .categoryName(categoryName)
                .sizeName(sizeName)
                .colorName(colorName)
                .MainImageUrl(MainImageUrl)
                .ThumbnailsImageUrl(ThumbnailsImageUrl)
                .explainImageUrl(explainImageUrl)
                .totalFavorite(totalFavorite)
                .build();
    }

}
