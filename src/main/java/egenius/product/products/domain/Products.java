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
    private List<ProductDetails> producrDetail; // 세부 상품들
    private List<String> ThumbnailsImageUrl; // 썸네일Url
    private List<String> explainImageUrl; // 설명 이미지 Url
    private String vendorEmail; // 판매자 정보 (이메일)
    private String salesStatus; // 판매 상태 (0: 판매중, 1: 품절, 2: 판매중지)
    private Integer salesCount; // 재고 수량
    private Integer saveCount; // 안심 재고 수량

//    // 상품 생성
//    public static Products createProducts(String productName, Integer productPrice, String productCode,
//                                          String brandName, String brandLogoUrl, Integer discount,
//                                          DiscountTypes discountTypes, Integer totalFavorite,
//                                          List<String> categoryName, List<String> sizeName,
//                                          List<String> colorName, List<String> ThumbnailsImageUrl,
//                                          List<String> explainImageUrl, String vendorEmail) {
//        return Products.builder()
//                .productName(productName)
//                .productPrice(productPrice)
//                .productCode(productCode)
//                .brandName(brandName)
//                .brandLogoUrl(brandLogoUrl)
//                .discount(discount)
//                .discountTypes(discountTypes)
//                .totalFavorite(totalFavorite)
//                .categoryName(categoryName)
//                .sizeName(sizeName)
//                .colorName(colorName)
//                .ThumbnailsImageUrl(ThumbnailsImageUrl)
//                .explainImageUrl(explainImageUrl)
//                .vendorEmail(vendorEmail)
//                .build();
//    }


}
