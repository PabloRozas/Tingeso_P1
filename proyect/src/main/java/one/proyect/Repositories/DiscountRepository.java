package one.proyect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import one.proyect.Entities.DiscountEntity;

import java.util.List;

public interface DiscountRepository extends JpaRepository<DiscountEntity, Long> {
    List<DiscountEntity> findAllByEngineTypeIdAndDiscountTypeId(Long id_engine_type, Long id_discount_type);

    @Query(value = "SELECT * FROM discount WHERE discount_type_id = :id_discount_type", nativeQuery = true)
    List<DiscountEntity> findAllByDiscountTypeId(@Param("id_discount_type") Long id_discount_type);
}
