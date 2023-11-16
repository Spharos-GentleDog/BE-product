package egenius.product.products.adaptor.infrastructure.mysql.repository;

import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductSizeListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSizeListRepository extends JpaRepository<ProductSizeListEntity, Long> {
}
