package one.proyect.Services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import one.proyect.Entities.VehicleTypeEntity;
import one.proyect.Repositories.VehicleTypeRepository;

import java.util.List;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public VehicleTypeEntity getVehicleTypeById(Long id) {
        return vehicleTypeRepository.findById(id).orElse(null);
    }

    public List<VehicleTypeEntity> getAllVehicleType() {
        return vehicleTypeRepository.findAll();
    }
}
