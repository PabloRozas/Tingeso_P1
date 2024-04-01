package one.proyect.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import one.proyect.Entities.VehicleTypeEntity;
import one.proyect.Services.VehicleTypeService;

import java.util.List;

@RestController
@RequestMapping("/vehicleType")
@CrossOrigin("*")
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @Autowired
    public VehicleTypeController(VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }

    @GetMapping("/all")
    public List<VehicleTypeEntity> getAllVehicleType() {
        return vehicleTypeService.getAllVehicleType();
    }
}
