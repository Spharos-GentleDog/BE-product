package egenius.product.products.adaptor.infrastructure.mysql.repository;

import egenius.product.categorys.adaptor.infrastructure.mysql.entity.ProductCategoryEntity;
import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductCategoryListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductCategoryListRepository extends JpaRepository<ProductCategoryListEntity, Long> {

    @Query("select count(p) from ProductCategoryListEntity p where p.categoryId = :categoryId")
    Integer findByCategoryId(@Param("categoryId") ProductCategoryEntity productCategoryEntity);
}
