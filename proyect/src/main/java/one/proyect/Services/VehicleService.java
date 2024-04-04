package one.proyect.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import one.proyect.Entities.VehicleEntity;
import one.proyect.Repositories.VehicleRepository;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public ResponseEntity<String> createVehicle(VehicleEntity vehicle) {
        if (vehicleRepository.findByPatent(vehicle.getPatent()) != null) {
            return ResponseEntity.badRequest().body("La patente ya se encuentra registrada");
        }
        vehicleRepository.save(vehicle);
        return ResponseEntity.ok().body("Vehículo creado correctamente");
    }

    public VehicleEntity getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

}
