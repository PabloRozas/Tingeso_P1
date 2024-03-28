package one.proyect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.proyect.Entities.VehicleEntity;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

}
