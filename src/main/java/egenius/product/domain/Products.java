package egenius.product.domain;

import egenius.product.domain.enums.DiscountTypes;
import egenius.product.global.common.BaseTimeEntity;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class Products {

    private String productName;
    private Integer productPrice;
    private String productCode;
    private String brandName;
    private String brandLogoUrl;
    private Integer discount;
    private DiscountTypes discountTypes;
    private String productImageUrl;


}
