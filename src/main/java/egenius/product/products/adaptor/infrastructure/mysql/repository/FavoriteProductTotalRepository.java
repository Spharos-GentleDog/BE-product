package egenius.product.products.adaptor.infrastructure.mysql.repository;

import egenius.product.products.adaptor.infrastructure.mysql.entity.FavoriteProductTotalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteProductTotalRepository extends JpaRepository<FavoriteProductTotalEntity, Long> {

}
