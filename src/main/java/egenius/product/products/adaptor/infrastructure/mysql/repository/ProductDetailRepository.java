package egenius.product.products.adaptor.infrastructure.mysql.repository;

import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Long> {
}
