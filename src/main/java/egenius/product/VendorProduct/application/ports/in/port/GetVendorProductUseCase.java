package egenius.product.VendorProduct.application.ports.in.port;

import egenius.product.VendorProduct.application.ports.in.query.GetVendorProductQuery;
import egenius.product.VendorProduct.application.ports.out.dto.GetVendorProductDto;

import java.util.List;

public interface GetVendorProductUseCase {

    List<GetVendorProductDto> getVendorProduct(GetVendorProductQuery getVendorProductQuery);
}