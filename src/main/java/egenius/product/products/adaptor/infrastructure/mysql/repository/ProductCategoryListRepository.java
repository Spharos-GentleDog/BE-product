package egenius.product.products.adaptor.infrastructure.mysql.repository;

import egenius.product.categorys.adaptor.infrastructure.mysql.entity.ProductCategoryEntity;
import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductCategoryListEntity;
import egenius.product.products.adaptor.infrastructure.mysql.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryListRepository extends JpaRepository<ProductCategoryListEntity, Long> {

    // 상품 판매 여부가 삭제면 해당 개수는 카운트 조회 되지 않게 해야 한다 (삭제된 상품은 카테고리에 노출되지 않는다)
    @Query("select count(p) from ProductCategoryListEntity p where p.categoryId = :categoryId")
    Integer countActiveProductsByCategoryId(@Param("categoryId") ProductCategoryEntity productCategoryEntity);

    List<ProductCategoryListEntity> findByCategoryId(ProductCategoryEntity productCategoryEntity);
}
