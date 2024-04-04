package one.proyect.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.proyect.Repositories.RepairTypeRepository;
import one.proyect.Entities.RepairTypeEntity;

import java.util.List;

@Service
public class RepairTypeService {
    @Autowired
    private RepairTypeRepository repairTypeRepository;

    public List<RepairTypeEntity> getAllRepairTypes() {
        return repairTypeRepository.findAll();
    }

    public RepairTypeEntity getRepairTypeById(Long id) {
        return repairTypeRepository.findById(id).orElse(null);
    }
}