package one.proyect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import one.proyect.Entities.SurchargeEntity;
import java.util.List;

public interface SurchargeRepository extends JpaRepository<SurchargeEntity, Long> {

    @Query(value = "SELECT * FROM surcharge WHERE id_surcharge_type = :id", nativeQuery = true)
    List<SurchargeEntity> findByTypeSurcharge(@Param("id") Long id);

}
