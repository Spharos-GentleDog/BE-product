package egenius.product.products.adaptor.infrastructure.mysql.repository;

import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductEntity;
import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductThumbnailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductThumbnailsRepository extends JpaRepository<ProductThumbnailsEntity, Long> {
    ProductThumbnailsEntity findByProductIdAndUsedMainImage(ProductEntity productEntity, Integer usedMainImage);

    List<ProductThumbnailsEntity> findByProductId(ProductEntity productEntity);
}
