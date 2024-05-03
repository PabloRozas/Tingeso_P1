package one.proyect.Controllers;

import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import one.proyect.Entities.ReparationEntity;
import one.proyect.Entities.VoucherEntity;
import one.proyect.Services.ReparationService;
import one.proyect.Services.VehicleService;

@RestController
@RequestMapping("/reparation")
@CrossOrigin(origins = "*")
public class ReparationController {

    @Autowired
    private ReparationService reparationService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    public ReparationController(ReparationService reparationService) {
        this.reparationService = reparationService;
    }

    @GetMapping("/all")
    public List<ReparationEntity> getAllReparations() {
        return reparationService.getAllReparations();
    }

    @PostMapping("/create")
    public ReparationEntity createReparation(@RequestBody Map<String, String> credentials) {
        String date_admision = credentials.get("date_admision");
        String entry_time = credentials.get("entry_time");
        String departure_date = credentials.get("departure_date");
        String departure_time = credentials.get("daparture_time");
        Long id_vehicle = Long.parseLong(credentials.get("vehicle"));
        ReparationEntity reparation = new ReparationEntity();
        reparation.setDate_admission(date_admision);
        reparation.setEntry_time(entry_time);
        reparation.setDeparture_date(departure_date);
        reparation.setDeparture_time(departure_time);
        reparation.setVehicle(vehicleService.getVehicleById(id_vehicle));
        reparation.setRetirement_date("");
        reparation.setRetirement_time("");
        reparationService.createReparation(reparation);
        return reparation;
    }

    @PostMapping("/addRepairType")
    public String addRepairTypeToReparation(@RequestBody Map<String, String> credentials) {
        Long id_reparation = Long.parseLong(credentials.get("reparation"));
        Long id_repair_type = Long.parseLong(credentials.get("repair_type"));
        reparationService.addRepairTypeToReparation(id_reparation, id_repair_type);
        return "Repair type added to reparation";
    }

    @PostMapping("/calculateVoucher")
    public VoucherEntity calculateVoucher(@RequestBody Map<String, String> credentials) {
        Long id_reparation = Long.parseLong(credentials.get("reparation"));
        return reparationService.calculateVoucher(id_reparation);
    }

    @PutMapping("/pay/{id}")
    public ReparationEntity payReparation(@PathVariable Long id) {
        return reparationService.payReparation(id);
    }
}
