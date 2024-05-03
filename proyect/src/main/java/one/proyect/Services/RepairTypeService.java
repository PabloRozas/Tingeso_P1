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

    public List<?> getReport2(Long id_vehicle_type) {
        return repairTypeRepository.getReport2(id_vehicle_type);
    }

    public List<?> getReport4(Long id_engine_type) {
        return repairTypeRepository.getReport4(id_engine_type);
    }
}