package egenius.product.VendorProduct.application.ports.in.port;

import egenius.product.VendorProduct.application.ports.in.query.UpdateVendorProductQuery;

public interface UpdateVendorProductUseCase {

    void updateVendorProduct(UpdateVendorProductQuery updateVendorProductQuery);
}
