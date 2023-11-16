package egenius.product.sizes.adaptor.infrastructure.mysql.repository;

import egenius.product.sizes.adaptor.infrastructure.mysql.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SizesRepository extends JpaRepository<SizeEntity, Integer> {

    Optional<SizeEntity> findBySizeName(String sizeName);

}
