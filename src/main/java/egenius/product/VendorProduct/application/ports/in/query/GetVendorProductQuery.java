package egenius.product.VendorProduct.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetVendorProductQuery {

    private String vendorEmail; // 판매자 email

    public static GetVendorProductQuery toQuery(String vendorEmail){
        return GetVendorProductQuery.builder()
                .vendorEmail(vendorEmail)
                .build();
    }
}

