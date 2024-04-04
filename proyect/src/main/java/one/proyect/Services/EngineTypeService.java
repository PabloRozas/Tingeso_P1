package one.proyect.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.proyect.Repositories.EngineTypeRepository;
import one.proyect.Entities.EngineTypeEntity;

import java.util.List;

@Service
public class EngineTypeService {
    @Autowired
    private EngineTypeRepository engineTypeRepository;

    public EngineTypeEntity getEngineTypeById(Long id) {
        return engineTypeRepository.findById(id).orElse(null);
    }

    public List<EngineTypeEntity> getAllEngineType() {
        return engineTypeRepository.findAll();
    }
}
