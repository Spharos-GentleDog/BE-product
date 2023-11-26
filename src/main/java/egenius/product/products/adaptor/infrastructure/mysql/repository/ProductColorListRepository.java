package egenius.product.products.adaptor.infrastructure.mysql.repository;

import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductColorListEntity;
import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductColorListRepository extends JpaRepository<ProductColorListEntity, Long> {
    List<ProductColorListEntity> findByProductId(ProductEntity productEntity);

}
