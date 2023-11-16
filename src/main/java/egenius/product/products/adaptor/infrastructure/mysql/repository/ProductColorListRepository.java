package egenius.product.products.adaptor.infrastructure.mysql.repository;

import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductColorListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductColorListRepository extends JpaRepository<ProductColorListEntity, Long> {
}
