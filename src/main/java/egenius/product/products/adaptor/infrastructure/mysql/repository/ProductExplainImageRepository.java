package egenius.product.products.adaptor.infrastructure.mysql.repository;

import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductExplainImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductExplainImageRepository extends JpaRepository<ProductExplainImageEntity, Long> {
}
