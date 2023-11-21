package egenius.product.VendorProduct.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DeleteVendorProductQuery {

    private String vendorEmail;
    private Long ProductDetailId;

    public static DeleteVendorProductQuery toQuery(String vendorEmail, Long ProductDetailId){
        return DeleteVendorProductQuery.builder()
                .vendorEmail(vendorEmail)
                .ProductDetailId(ProductDetailId)
                .build();
    }
}

