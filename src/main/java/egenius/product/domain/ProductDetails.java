package egenius.product.domain;

import egenius.product.domain.enums.DiscountTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProductDetails {

    private String productDetailCode; // 상품 코드
    private Integer productPrice; // 상품 가격
    private Integer discountRate; // 할인율
    private DiscountTypes discountTypes; // 할인 타입 (0: 퍼센트, 1: 금액)
    private String colorName; // 컬러명
    private String sizeName; // 사이즈명


}
