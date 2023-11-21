package egenius.product.VendorProduct.application.ports.out.port;

import egenius.product.VendorProduct.application.ports.out.dto.GetSalesCountDto;
import egenius.product.VendorProduct.domain.VendorProduct;

public interface GetSalesCountPort {

    GetSalesCountDto getSalesCount(VendorProduct vendorProduct);
}
