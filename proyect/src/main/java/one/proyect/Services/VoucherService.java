package one.proyect.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.proyect.Entities.VoucherEntity;
import one.proyect.Repositories.VoucherRepository;

@Service
public class VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private SurchargeService surchargeService;

    @Autowired
    public VehicleService vehicleService;

    public VoucherEntity createVoucher(VoucherEntity voucher) {
        return voucherRepository.save(voucher);
    }

    public void addDiscount(VoucherEntity voucher, Long discountId) {
        voucher.getDiscounts().add(discountService.getDiscountById(discountId));
        voucherRepository.save(voucher);
    }

    public void addSurcharge(VoucherEntity voucher, Long surchargeId) {
        voucher.getSurcharges().add(surchargeService.getSurchargeById(surchargeId));
        voucherRepository.save(voucher);
    }

    public VoucherEntity getVoucherById(Long id) {
        return voucherRepository.findById(id).get();
    }
}
