package one.proyect.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.proyect.Entities.ReparationEntity;
import one.proyect.Entities.VoucherEntity;
import one.proyect.Repositories.VoucherRepository;

@Service
public class VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private DiscountService discountService;

    @Autowired
    public VehicleService vehicleService;

    public VoucherEntity createVoucher(Double mount, Long id_vehicle, Integer count_rep, String date_reparation,
            String time_reparation) {
        VoucherEntity voucher = new VoucherEntity();
        voucher.setMount(mount);

        // Descuentos de la cantidad de reparaciones
        discountService.getDiscounts(vehicleService.getVehicleById(id_vehicle).getEngineType().getId(), 1L)
                .forEach(discount -> {
                    // Se separa la descripcion del descuento por el simbolo "-"
                    String[] parts = discount.getDescription().split("-");

                    if (parts[1].equals("+") && count_rep >= Integer.parseInt(parts[0])) {
                        System.out.println("Descuento de cantidad de reparaciones: " +
                                discount.getPercentage());
                    } else if (Integer.parseInt(parts[0]) <= count_rep && Integer.parseInt(parts[1]) >= count_rep) {
                        System.out.println("Descuento de cantidad de reparaciones: " +
                                discount.getPercentage());
                    } else {
                        System.out.println("No hay descuento por cantidad de reparaciones: " +
                                count_rep);
                    }
                });
        // Descuentos por el dia de reparacion
        discountService.getDiscounts(vehicleService.getVehicleById(id_vehicle).getEngineType().getId(), 2L)
                .forEach(discount -> {
                    // Se separa la descripcion del descuento por el simbolo "-"
                    String[] parts = discount.getDescription().split("-");
                    String[] parts2 = date_reparation.split("/");

                    // La fecha se ingresa en formato dd/mm/yyyy por lo que hay que traducirla a
                    // lunes o jueves

                });

        return voucher;

    }
}
