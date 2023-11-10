package egenius.product.colors.adaptor.infrastructure.mysql.repository;

import egenius.product.colors.adaptor.infrastructure.mysql.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<ColorEntity, Long> {
}
