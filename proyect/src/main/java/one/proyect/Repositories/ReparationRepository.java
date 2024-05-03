package one.proyect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import one.proyect.Entities.ReparationEntity;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface ReparationRepository extends JpaRepository<ReparationEntity, Long> {
    List<ReparationEntity> findByVehicleId(Long id_vehicle);

    @NonNull
    Optional<ReparationEntity> findById(@NonNull Long id);

    @NonNull
    List<ReparationEntity> findAll();

    @Query(value = "SELECT repair_type_id FROM reparation_repair_type WHERE reparation_id = :reparation_id", nativeQuery = true)
    List<Long> findRepairTypeByReparationId(@Param("reparation_id") Long reparation_id);
}
