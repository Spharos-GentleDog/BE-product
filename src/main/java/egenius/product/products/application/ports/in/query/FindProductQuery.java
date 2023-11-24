package egenius.product.products.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindProductQuery {

    private Object category; // 카테고리 ID
    private String sizeName; // 사이즈 ID
    private String colorName; // 컬러 ID
    private String productType; // 상품 타입 (new : 최신순, wish: 찜순, lowPrice: 낮은 가격순, highPrice: 높은 가격순)
    private Integer minPrice; // 최소 가격
    private Integer maxPrice; // 최대 가격
    private Boolean isDiscount; // 할인 상품 여부
    private Integer page; // 페이지

    public static FindProductQuery toQuery(Object category, String sizeName, String colorName,
                                                          String productType, Integer minPrice, Integer maxPrice,
                                                          Boolean isDiscount, Integer page) {
        return FindProductQuery.builder()
                .category(category)
                .sizeName(sizeName)
                .colorName(colorName)
                .productType(productType)
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .isDiscount(isDiscount)
                .page(page)
                .build();
    }
}
