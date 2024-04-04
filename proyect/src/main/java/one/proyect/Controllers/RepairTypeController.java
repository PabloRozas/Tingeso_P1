package one.proyect.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
