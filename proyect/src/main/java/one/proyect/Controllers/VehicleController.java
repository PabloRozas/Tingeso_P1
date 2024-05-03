package one.proyect.Controllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import one.proyect.Entities.VehicleEntity;
import one.proyect.Services.VehicleService;
import one.proyect.Services.EngineTypeService;
import one.proyect.Services.BrandsService;
import one.proyect.Services.VehicleTypeService;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private EngineTypeService engineTypeService;

    @Autowired
    private BrandsService brandsService;

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/create")
    public VehicleEntity createVehicle(@RequestBody Map<String, String> credentials) {
        String patent = credentials.get("patent");
        String model = credentials.get("model");
        String year_production = credentials.get("year_production");
        Integer number_seats = Integer.parseInt(credentials.get("number_seats"));
        Long id_engine_type = Long.parseLong(credentials.get("id_engine_type"));
        Long id_brand = Long.parseLong(credentials.get("id_brand"));
        Long id_vehicle_type = Long.parseLong(credentials.get("id_vehicle_type"));
        Integer km = Integer.parseInt(credentials.get("km"));
        VehicleEntity vehicle = new VehicleEntity();
        vehicle.setPatent(patent);
        vehicle.setModel(model);
        vehicle.setYear_production(year_production);
        vehicle.setNumber_seats(number_seats);
        vehicle.setEngineType(engineTypeService.getEngineTypeById(id_engine_type));
        vehicle.setBrand(brandsService.getBrandById(id_brand));
        vehicle.setVehicleType(vehicleTypeService.getVehicleTypeById(id_vehicle_type));
        vehicle.setKm(km);
        vehicleService.createVehicle(vehicle);
        return vehicle;
    }

    @GetMapping("/all")
    public List<VehicleEntity> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/get/{id}")
    public VehicleEntity getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    @GetMapping("/getByPatent/{patent}")
    public VehicleEntity getVehicleByPatent(@PathVariable String patent) {
        return vehicleService.getVehicleByPatent(patent);
    }

}
