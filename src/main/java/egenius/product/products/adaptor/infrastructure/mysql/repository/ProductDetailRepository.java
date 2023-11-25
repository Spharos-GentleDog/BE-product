package egenius.product.products.adaptor.infrastructure.mysql.repository;

import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductDetailEntity;
import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Long> {


    @Query(value = "SELECT * FROM product_details where product_id = :productId and discount_rate is not null", nativeQuery = true)
    List<ProductDetailEntity> discsountProductByProductId(@Param("productId") Long productId);

    @Query(value = "SELECT * FROM product_details where product_id = :productId and discount_rate is null", nativeQuery = true)
    List<ProductDetailEntity> noDiscsountProductByProductId(@Param("productId") Long productId);
}
