package egenius.product.sizes.adaptor.infrastructure.mysql.repository;

import egenius.product.sizes.adaptor.infrastructure.mysql.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizesRepository extends JpaRepository<SizeEntity, Integer> {


}
