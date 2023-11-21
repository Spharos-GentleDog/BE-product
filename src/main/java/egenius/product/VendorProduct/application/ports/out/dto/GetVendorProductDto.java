package egenius.product.VendorProduct.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetVendorProductDto {

    private String mainImageUrl;
    private String productName;
    private Long productId;
    private String productCode;
    private Long productDetailId;
    private String productDetailCode;
    private  Integer salesCount;
    private Integer price;
    private Integer totalFavoriteCount;
    private String displayStatus;
    private String  salesStatus;

    public static GetVendorProductDto fromGetVendorProduct(String mainImageUrl, String productName, Long productId,
                                                           String productCode, Long productDetailId,
                                                           String productDetailCode, Integer salesCount,
                                                           Integer price, Integer totalFavoriteCount,
                                                           String displayStatus, String salesStatus) {
        return GetVendorProductDto.builder()
                .mainImageUrl(mainImageUrl)
                .productName(productName)
                .productId(productId)
                .productCode(productCode)
                .productDetailId(productDetailId)
                .productDetailCode(productDetailCode)
                .salesCount(salesCount)
                .price(price)
                .totalFavoriteCount(totalFavoriteCount)
                .displayStatus(displayStatus)
                .salesStatus(salesStatus)
                .build();
    }
}
