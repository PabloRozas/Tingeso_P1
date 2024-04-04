package one.proyect.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import one.proyect.Entities.EngineTypeEntity;
import one.proyect.Services.EngineTypeService;

import java.util.List;

@RestController
@RequestMapping("/engineType")
@CrossOrigin("*")
public class EngineTypeController {

    @Autowired
    private EngineTypeService engineTypeService;

    @Autowired
    public EngineTypeController(EngineTypeService engineTypeService) {
        this.engineTypeService = engineTypeService;
    }

    @GetMapping("/all")
    public List<EngineTypeEntity> getAllEngineType() {
        return engineTypeService.getAllEngineType();
    }
}
