package one.proyect.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.proyect.Entities.BrandsEntity;
import one.proyect.Entities.Report3;
import one.proyect.Services.BrandsService;

import java.util.List;

@RestController
@RequestMapping("/brands")
@CrossOrigin("*")
public class BrandsController {

    @Autowired
    private BrandsService brandsService;

    @Autowired
    public BrandsController(BrandsService brandsService) {
        this.brandsService = brandsService;
    }

    @GetMapping("/all")
    public List<BrandsEntity> getAllBrands() {
        return brandsService.getAllBrands();
    }

    @GetMapping("/report3")
    public List<Report3> getReport3() {
        return brandsService.getReport3();
    }
}
