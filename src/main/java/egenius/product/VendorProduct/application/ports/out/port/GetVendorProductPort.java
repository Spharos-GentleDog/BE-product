package egenius.product.VendorProduct.application.ports.out.port;

import egenius.product.VendorProduct.application.ports.out.dto.GetVendorProductDto;

import java.util.List;

public interface GetVendorProductPort {

    List<GetVendorProductDto> getVendorProduct(String vendorEmail);
}
