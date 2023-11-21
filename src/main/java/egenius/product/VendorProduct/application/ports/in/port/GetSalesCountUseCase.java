package egenius.product.VendorProduct.application.ports.in.port;

import egenius.product.VendorProduct.application.ports.in.query.GetSalesCountQuery;
import egenius.product.VendorProduct.application.ports.out.dto.GetSalesCountDto;

public interface GetSalesCountUseCase {

    GetSalesCountDto getSalesCount(GetSalesCountQuery getSalesCountQuery);
}
