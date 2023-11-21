package egenius.product.categorys.adaptor.infrastructure.mysql.repository;

import egenius.product.categorys.adaptor.infrastructure.mysql.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<ProductCategoryEntity,Integer> {

    Optional<ProductCategoryEntity> findByCategoryName(String parentCategoryName);

    @Query(value = "SELECT * FROM product_category where parent_category is null", nativeQuery = true)
    List<ProductCategoryEntity> findByParentCategoryIsNull(); // 부모 카테고리 조회

    // 자식 카테고리 조회
    List<ProductCategoryEntity> findByParentCategory(ProductCategoryEntity productCategoryEntity);
}
