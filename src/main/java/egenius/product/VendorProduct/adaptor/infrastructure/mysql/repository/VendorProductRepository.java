package egenius.product.VendorProduct.adaptor.infrastructure.mysql.repository;

import egenius.product.VendorProduct.adaptor.infrastructure.mysql.entity.VendorProductEntity;
import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendorProductRepository extends JpaRepository<VendorProductEntity, Long> {

    VendorProductEntity findByVendorEmailAndProductDetailId(String vendorEmail, ProductDetailEntity productDetailId);

    List<VendorProductEntity> findAllByVendorEmail(String vendorEmail);

    VendorProductEntity findByProductDetailId(ProductDetailEntity productDetailId);
}
