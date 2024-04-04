package one.proyect.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.proyect.Repositories.ReparationRepository;
import one.proyect.Entities.ReparationEntity;
import one.proyect.Entities.VoucherEntity;

@Service
public class ReparationService {
    @Autowired
    private ReparationRepository reparationRepository;

    @Autowired
    private PriceService priceService;

    public ReparationEntity getReparationById(Long id) {
        return reparationRepository.findById(id).orElse(null);
    }

    public ReparationEntity createReparation(ReparationEntity reparation) {
        VoucherEntity voucher = new VoucherEntity();
        voucher.setMount(priceService.getPriceByRepairTypeandEngineType(reparation.getRepairType().getId(),
                reparation.getVehicle().getEngineType().getId()).getPrice());
        System.out.println("El monto es: " + voucher.getMount());
        return reparation;
    }
}
