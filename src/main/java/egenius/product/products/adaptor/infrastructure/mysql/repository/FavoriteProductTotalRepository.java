package egenius.product.products.adaptor.infrastructure.mysql.repository;

import egenius.product.products.adaptor.infrastructure.mysql.entity.FavoriteProductTotalEntity;
import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteProductTotalRepository extends JpaRepository<FavoriteProductTotalEntity, Long> {

    FavoriteProductTotalEntity findByProductId(ProductEntity productEntity);
}
