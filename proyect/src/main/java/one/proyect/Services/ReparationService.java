package one.proyect.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.proyect.Repositories.ReparationRepository;
import one.proyect.Entities.DiscountEntity;
import one.proyect.Entities.PriceEntity;
import one.proyect.Entities.RepairTypeEntity;
import one.proyect.Entities.ReparationEntity;
import one.proyect.Entities.SurchargeEntity;
import one.proyect.Entities.VehicleEntity;
import one.proyect.Entities.VoucherEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ReparationService {
    @Autowired
    private ReparationRepository reparationRepository;

    @Autowired
    private RepairTypeService repairTypeService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private SurchargeService surchargeEntity;

    @Autowired
    private VoucherService voucherService;

    public ReparationEntity getReparationById(Long id) {
        return reparationRepository.findById(id).orElse(null);
    }

    public List<ReparationEntity> getReparationsByVehicle(Long id_vehicle) {
        return reparationRepository.findByVehicleId(id_vehicle);
    }

    public ReparationEntity createReparation(ReparationEntity reparation) {
        // Integer total_reparations =
        // getReparationsVehicle(reparation.getVehicle().getId()).size();
        if (reparation.getVehicle() == null) {
            return null;
        }
        reparationRepository.save(reparation);
        // VoucherEntity first_voucher = voucherService
        // .createVoucher(priceService.getPriceByRepairTypeandEngineType(reparation.getRepairType().getId(),
        // reparation.getVehicle().getEngineType().getId()).getPrice(),
        // reparation.getVehicle().getId(),
        // total_reparations, reparation.getDate_admission(),
        // reparation.getEntry_time());

        return reparation;
    }

    public List<ReparationEntity> getAllReparations() {
        return reparationRepository.findAll();
    }

    public List<ReparationEntity> getReparationsVehicle(Long id_vehicle) {
        return reparationRepository.findByVehicleId(id_vehicle);
    }

    public void addRepairTypeToReparation(Long id_reparation, Long id_repair_type) {
        ReparationEntity reparation = reparationRepository.findById(id_reparation).orElse(null);
        RepairTypeEntity repairType = repairTypeService.getRepairTypeById(id_repair_type);
        reparation.getRepairTypes().add(repairType);
        reparationRepository.save(reparation);
    }

    public VoucherEntity calculateVoucher(Long id_reparation) {
        ReparationEntity reparation = reparationRepository.findById(id_reparation).orElse(null);
        VoucherEntity voucher = new VoucherEntity();
        VehicleEntity vehicle = reparation.getVehicle();
        List<PriceEntity> prices = priceService.getAllPrices();
        ArrayList<RepairTypeEntity> repairTypes = new ArrayList<>();
        List<Long> repairTypeIds = reparationRepository.findRepairTypeByReparationId(id_reparation);

        for (Long repairTypeId : repairTypeIds) {
            repairTypes.add(repairTypeService.getRepairTypeById(repairTypeId));
        }

        Double mount_reparations = 0.0;
        for (RepairTypeEntity repairType : repairTypes) {
            for (PriceEntity price : prices) {
                if (repairType.getId() == price.getRepairType().getId()
                        && vehicle.getEngineType().getId() == price.getEngineType().getId()) {
                    mount_reparations += price.getPrice();
                }
            }
        }

        System.out.println("Monto total: " + mount_reparations);
        // Se guarda el mount_reparations en el voucher en el atributo
        // total_reparations, primero se debe pasar a integer
        voucher.setTotal_reparations(mount_reparations.intValue());

        // Aplicacion de descuentos

        Double mount_reparations_discount1 = 0.0;

        List<DiscountEntity> discounts = discountService.getDiscountsByTypeDiscount(1L);
        for (DiscountEntity discount : discounts) {
            if (discount.getDescription().split("-")[0].equals("10+")) {
                if (discount.getEngineType().getId() == vehicle.getEngineType().getId()
                        && repairTypes.size() >= 10) {
                    mount_reparations_discount1 = (mount_reparations * discount.getPercentage() * 0.01);
                    voucherService.addDiscount(voucher, discount.getId());
                    break;
                } else {
                    continue;
                }
            } else if ((Integer.parseInt(discount.getDescription().split("-")[0]) <= repairTypes.size()
                    && Integer.parseInt(discount.getDescription().split("-")[1]) >= repairTypes.size())
                    && discount.getEngineType().getId() == vehicle.getEngineType().getId()) {

                mount_reparations_discount1 = (mount_reparations * discount.getPercentage() * 0.01);
                voucherService.addDiscount(voucher, discount.getId());
                break;

            }
        }

        System.out.println("Descuento 1: " + mount_reparations_discount1);
        voucher.setDiscount1(mount_reparations_discount1.intValue());

        Double mount_reparations_discount2 = 0.0;
        List<DiscountEntity> discounts2 = discountService.getDiscountsByTypeDiscount(2L);
        // Se pasa la fecha de tipo string dd/mm/yyyy a tipo date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = formatter.parse(reparation.getDate_admission());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Integer day = cal.get(Calendar.DAY_OF_WEEK);

        for (DiscountEntity discount : discounts2) {
            if ((day == 5 || day == 2)
                    && Integer.parseInt(reparation.getEntry_time().split(":")[0]) <= Integer
                            .parseInt(discount.getDescription().split("-")[1].split(":")[0])
                    && Integer.parseInt(reparation.getEntry_time().split(":")[0]) >= Integer
                            .parseInt(discount.getDescription().split("-")[0].split(":")[0])
                    && discount.getEngineType().getId() == vehicle.getEngineType().getId()) {
                mount_reparations_discount2 = (mount_reparations * discount.getPercentage() * 0.01);
                voucherService.addDiscount(voucher, discount.getId());
                break;
            }
        }

        System.out.println("Descuento 2: " + mount_reparations_discount2);
        voucher.setDiscount2(mount_reparations_discount2.intValue());

        // Aplicacion de recargos

        Double mount_reparations_surcharge1 = 0.0;
        List<SurchargeEntity> surcharges = surchargeEntity.getSurchargesByTypeSurcharge(1L);
        for (SurchargeEntity surcharge : surcharges) {
            if (surcharge.getDescription().split("-")[0].equals("40001+")) {
                if (surcharge.getVehicleType().getId() == vehicle.getVehicleType().getId()
                        && vehicle.getKm() >= 40001) {

                    mount_reparations_surcharge1 = (mount_reparations * surcharge.getPercentage() * 0.01);
                    voucherService.addSurcharge(voucher, surcharge.getId());
                    break;
                } else {

                    continue;
                }

            } else if ((Integer.parseInt(surcharge.getDescription().split("-")[0]) <= vehicle.getKm()
                    && Integer.parseInt(surcharge.getDescription().split("-")[1]) >= vehicle.getKm())
                    && surcharge.getVehicleType().getId() == vehicle.getVehicleType().getId()) {
                mount_reparations_surcharge1 = (mount_reparations * surcharge.getPercentage() * 0.01);
                voucherService.addSurcharge(voucher, surcharge.getId());
                break;
            }
        }

        System.out.println("Recargo 1: " + mount_reparations_surcharge1);
        voucher.setSurcharge1(mount_reparations_surcharge1.intValue());

        Double mount_reparations_surcharge2 = 0.0;

        List<SurchargeEntity> surcharges2 = surchargeEntity.getSurchargesByTypeSurcharge(2L);
        // anios de antiguedad del vehiculo
        Integer year_antiquity = Calendar.getInstance().get(Calendar.YEAR)
                - Integer.parseInt(vehicle.getYear_production());

        for (SurchargeEntity surcharge : surcharges2) {
            if (surcharge.getDescription().split("-")[0].equals("16+")) {
                if (surcharge.getVehicleType().getId() == vehicle.getVehicleType().getId() && year_antiquity >= 16) {

                    mount_reparations_surcharge2 = (mount_reparations * surcharge.getPercentage() * 0.01);
                    voucherService.addSurcharge(voucher, surcharge.getId());
                    break;
                } else {
                    continue;
                }
            } else if ((Integer.parseInt(surcharge.getDescription().split("-")[0]) <= year_antiquity
                    && Integer.parseInt(surcharge.getDescription().split("-")[1]) >= year_antiquity)
                    && surcharge.getVehicleType().getId() == vehicle.getVehicleType().getId()) {
                mount_reparations_surcharge2 = (mount_reparations * surcharge.getPercentage() * 0.01);
                voucherService.addSurcharge(voucher, surcharge.getId());
                break;
            }
        }

        System.out.println("Recargo 2: " + mount_reparations_surcharge2);
        voucher.setSurcharge2(mount_reparations_surcharge2.intValue());

        mount_reparations = (mount_reparations - mount_reparations_discount1 - mount_reparations_discount2
                + mount_reparations_surcharge1 + mount_reparations_surcharge2)
                + ((mount_reparations - mount_reparations_discount1 - mount_reparations_discount2
                        + mount_reparations_surcharge1 + mount_reparations_surcharge2) * 0.19);

        System.out.println("Monto total: " + mount_reparations);
        voucher.setMount(mount_reparations);
        reparation.setVoucher(voucher);
        reparationRepository.save(reparation);
        voucherService.createVoucher(voucher);

        return voucher;

    }

    public ReparationEntity payReparation(Long id) {
        ReparationEntity reparation = reparationRepository.findById(id).orElse(null);

        // Se trae la fecha y hora actual
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String retirement_date = formatter.format(date);
        formatter = new SimpleDateFormat("HH:mm");
        String retirement_time = formatter.format(date);
        reparation.setRetirement_date(retirement_date);
        reparation.setRetirement_time(retirement_time);

        VoucherEntity voucher = reparation.getVoucher();
        System.out.println("VOUCHERRRRRRRRRRR" + voucher);

        // Por cada dia de retraso se aplica un recargo del 5% sobre el monto total
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = new Date();
        try {
            date2 = formatter2.parse(reparation.getDeparture_date());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // se compara la fecha de salida con la fecha de retiro
        if (date2.compareTo(date) < 0) {
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA" + date2.compareTo(date));
            Integer days = (int) ((date.getTime() - date2.getTime()) / (1000 * 60 * 60 * 24));
            System.out.println("Dias de retraso: " + days);
            Double surcharge = (voucher.getMount() * (0.05 * days));
            System.out.println("Recargo por dias de retraso: " + surcharge);
            voucher.setSurcharge3(surcharge.intValue());
            voucher.setMount(voucher.getMount() + surcharge.intValue());
        } else {
            voucher.setSurcharge3(0);

        }

        voucher.setDiscount3(0);

        voucherService.createVoucher(voucher);

        reparationRepository.save(reparation);

        return reparation;

    }

}
