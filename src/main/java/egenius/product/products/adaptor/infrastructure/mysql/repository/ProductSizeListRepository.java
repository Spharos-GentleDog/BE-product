package egenius.product.products.adaptor.infrastructure.mysql.repository;

import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductEntity;
import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductSizeListEntity;
import egenius.product.sizes.adaptor.infrastructure.mysql.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductSizeListRepository extends JpaRepository<ProductSizeListEntity, Long> {
    List<ProductSizeListEntity> findByProductId(ProductEntity productEntity);
}
