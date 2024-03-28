package one.proyect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.proyect.Entities.VehicleTypeEntity;

public interface VehicleTypeRepository extends JpaRepository<VehicleTypeEntity, Long> {

}
