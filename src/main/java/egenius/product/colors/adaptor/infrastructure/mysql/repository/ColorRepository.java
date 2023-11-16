package egenius.product.colors.adaptor.infrastructure.mysql.repository;

import egenius.product.colors.adaptor.infrastructure.mysql.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<ColorEntity, Long> {

    Optional<ColorEntity> findByColorName(String colorName);
}
