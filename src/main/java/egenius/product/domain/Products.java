package egenius.product.domain;

import egenius.product.domain.enums.DiscountTypes;
import egenius.product.global.common.BaseTimeEntity;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Products {

    // 상품에 대한 정보

    private Long vendorId;
    private String productName;
    private Integer productPrice;
    private String productCode;
    private String brandName;
    private String brandLogoUrl;
    private Integer discountRate;
    private DiscountTypes discountTypes;
    private String productCategory;
    private List<String> productColorOptions; // 상품 색상 옵션 어떻게 넘겨 줄지 논의 필요
    private String productSize;
    private String productImageUrl;

}
