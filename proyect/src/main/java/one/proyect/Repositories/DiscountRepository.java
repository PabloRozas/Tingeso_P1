package one.proyect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.proyect.Entities.DiscountEntity;

import java.util.List;

public interface DiscountRepository extends JpaRepository<DiscountEntity, Long> {
    List<DiscountEntity> findAllByEngineTypeIdAndDiscountTypeId(Long id_engine_type, Long id_discount_type);
}
