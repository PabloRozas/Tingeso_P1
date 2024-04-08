package one.proyect.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.proyect.Repositories.ReparationRepository;
import one.proyect.Entities.ReparationEntity;
import one.proyect.Entities.VoucherEntity;

import java.util.List;

@Service
public class ReparationService {
    @Autowired
    private ReparationRepository reparationRepository;

    @Autowired
    private PriceService priceService;

    @Autowired
    private VoucherService voucherService;

    public ReparationEntity getReparationById(Long id) {
        return reparationRepository.findById(id).orElse(null);
    }

    public ReparationEntity createReparation(ReparationEntity reparation) {
        Integer total_reparations = getReparationsVehicle(reparation.getVehicle().getId()).size();
        VoucherEntity first_voucher = voucherService
                .createVoucher(priceService.getPriceByRepairTypeandEngineType(reparation.getRepairType().getId(),
                        reparation.getVehicle().getEngineType().getId()).getPrice(), reparation.getVehicle().getId(),
                        total_reparations, reparation.getDate_admission(), reparation.getEntry_time());

        return reparation;
    }

    public List<ReparationEntity> getReparationsVehicle(Long id_vehicle) {
        return reparationRepository.findByVehicleId(id_vehicle);
    }
}
