package one.proyect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import one.proyect.Entities.PriceEntity;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
    @Query("SELECT p FROM PriceEntity p WHERE p.repairType.id = :idRepairType AND p.engineType.id = :idEngineType")
    public PriceEntity findByRepairTypeandEngineType(@Param("idRepairType") Long idRepairType,
            @Param("idEngineType") Long idEngineType);
}
