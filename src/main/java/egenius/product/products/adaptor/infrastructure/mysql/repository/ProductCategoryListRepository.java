package egenius.product.products.adaptor.infrastructure.mysql.repository;

import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductCategoryListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryListRepository extends JpaRepository<ProductCategoryListEntity, Long> {
}
