package one.proyect.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import one.proyect.Entities.ReparationEntity;
import one.proyect.Services.ReparationService;
import one.proyect.Services.RepairTypeService;
import one.proyect.Services.VehicleService;

@RestController
@RequestMapping("/reparation")
@CrossOrigin(origins = "*")
public class ReparationController {

    @Autowired
    private ReparationService reparationService;

    @Autowired
    private RepairTypeService repairTypeService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    public ReparationController(ReparationService reparationService) {
        this.reparationService = reparationService;
    }

    @PostMapping("/create")
    public ReparationEntity createReparation(@RequestBody Map<String, String> credentials) {
        String date_admision = credentials.get("date_admision");
        String entry_time = credentials.get("entry_time");
        Long id_repair_type = Long.parseLong(credentials.get("repair_type"));
        String departure_date = credentials.get("departure_date");
        String departure_time = credentials.get("departure_time");
        Long id_vehicle = Long.parseLong(credentials.get("vehicle"));
        ReparationEntity reparation = new ReparationEntity();
        reparation.setDate_admission(date_admision);
        reparation.setEntry_time(entry_time);
        reparation.setRepairType(repairTypeService.getRepairTypeById(id_repair_type));
        reparation.setDeparture_date(departure_date);
        reparation.setDeparture_time(departure_time);
        reparation.setVehicle(vehicleService.getVehicleById(id_vehicle));
        reparationService.createReparation(reparation);
        return reparation;
    }
}
