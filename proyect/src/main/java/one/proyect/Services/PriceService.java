package one.proyect.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.proyect.Repositories.PriceRepository;
import one.proyect.Entities.PriceEntity;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;

    public PriceEntity getPriceById(Long id) {
        return priceRepository.findById(id).orElse(null);
    }

    public PriceEntity getPriceByRepairTypeandEngineType(Long repairTypeId, Long engineTypeId) {
        return priceRepository.findByRepairTypeandEngineType(repairTypeId, engineTypeId);
    }

    public List<PriceEntity> getAllPrices() {
        return priceRepository.findAll();
    }
}
