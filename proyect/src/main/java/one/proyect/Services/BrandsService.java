package one.proyect.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.proyect.Entities.BrandsEntity;
import one.proyect.Repositories.BrandsRepository;

import java.util.List;

@Service
public class BrandsService {

    @Autowired
    private BrandsRepository brandsRepository;

    public BrandsEntity getBrandById(Long id) {
        return brandsRepository.findById(id).orElse(null);
    }

    public List<BrandsEntity> getAllBrands() {
        return brandsRepository.findAll();
    }
}
