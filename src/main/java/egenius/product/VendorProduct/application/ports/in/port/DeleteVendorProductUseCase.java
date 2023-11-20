package egenius.product.VendorProduct.application.ports.in.port;

import egenius.product.VendorProduct.application.ports.in.query.DeleteVendorProductQuery;

public interface DeleteVendorProductUseCase {

    void deleteVendorProduct(DeleteVendorProductQuery deleteVendorProductQuery);
}
