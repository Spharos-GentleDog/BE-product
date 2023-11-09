package egenius.product.adaptor.infrastructure.mysql.repository;

import egenius.product.adaptor.infrastructure.mysql.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<ProductCategoryEntity,Integer> {

    Optional<ProductCategoryEntity> findByCategoryName(String parentCategoryName);
}
