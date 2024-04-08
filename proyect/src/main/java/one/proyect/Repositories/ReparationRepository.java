package one.proyect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.proyect.Entities.ReparationEntity;

import java.util.List;

public interface ReparationRepository extends JpaRepository<ReparationEntity, Long> {
    List<ReparationEntity> findByVehicleId(Long id_vehicle);
}
