package egenius.product.products.adaptor.infrastructure.mysql.repository;

import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductEntity;
import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductExplainImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductExplainImageRepository extends JpaRepository<ProductExplainImageEntity, Long> {
    List<ProductExplainImageEntity> findByProductId(ProductEntity productEntity);
}
