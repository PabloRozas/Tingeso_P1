package one.proyect.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import one.proyect.Entities.Report2;
import one.proyect.Entities.Report4;
import one.proyect.Services.RepairTypeService;

@RestController
@RequestMapping("/repairType")
@CrossOrigin(origins = "*")
public class RepairTypeController {

    @Autowired
    private RepairTypeService repairTypeService;

    @Autowired
    public RepairTypeController(RepairTypeService repairTypeService) {
        this.repairTypeService = repairTypeService;
    }

    @GetMapping("/all")
    public Object getAllRepairTypes() {
        return repairTypeService.getAllRepairTypes();
    }

    @GetMapping("/report2/{id_vehicle_type}")
    public List<Report2> getReparationsByVehicle(@PathVariable Long id_vehicle_type) {
        List<?> getReport2 = repairTypeService.getReport2(id_vehicle_type);
        List<Report2> report2 = new ArrayList<>();
        for (Object object : getReport2) {
            Object[] obj = (Object[]) object;
            Report2 report = new Report2(obj[0].toString(), obj[1].toString(), obj[2].toString());
            report2.add(report);

        }
        return report2;
    }

    @GetMapping("/report4/{id_engine_type}")
    public List<Report4> getReparationsByEngine(@PathVariable Long id_engine_type) {
        List<?> getReport3 = repairTypeService.getReport4(id_engine_type);
        List<Report4> report3 = new ArrayList<>();
        for (Object object : getReport3) {
            Object[] obj = (Object[]) object;
            Report4 report = new Report4(obj[0].toString(), obj[1].toString(), obj[2].toString());
            report3.add(report);

        }
        return report3;
    }
}
