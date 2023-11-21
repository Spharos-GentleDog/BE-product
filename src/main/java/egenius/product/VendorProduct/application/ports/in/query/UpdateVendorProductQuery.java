package egenius.product.VendorProduct.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateVendorProductQuery {
    private String vendorEmail;
    private Long productDetailId;
    private String displayStatus;
    private String salesStatus;
    private Integer salesCount;
    private Integer saveCount;

    public static UpdateVendorProductQuery toQuery(String vendorEmail, Long productDetailId, String displayStatus,
                                                   String salesStatus, Integer salesCount, Integer saveCount){
        return UpdateVendorProductQuery.builder()
                .vendorEmail(vendorEmail)
                .productDetailId(productDetailId)
                .displayStatus(displayStatus)
                .salesStatus(salesStatus)
                .salesCount(salesCount)
                .saveCount(saveCount)
                .build();
    }
}
