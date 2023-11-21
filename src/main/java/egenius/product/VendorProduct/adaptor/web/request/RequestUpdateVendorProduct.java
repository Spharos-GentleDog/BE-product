package egenius.product.VendorProduct.adaptor.web.request;

import lombok.Getter;

@Getter
public class RequestUpdateVendorProduct {

    private String vendorEmail;
    private Long productDetailId;
    private String displayStatus;
    private String salesStatus;
    private  Integer salesCount;
    private  Integer saveCount;
}
