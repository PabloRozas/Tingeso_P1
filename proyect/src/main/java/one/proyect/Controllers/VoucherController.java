package one.proyect.Controllers;

import org.springframework.web.bind.annotation.RestController;

import one.proyect.Services.ReparationService;
import one.proyect.Services.VehicleService;
import one.proyect.Services.VoucherService;
import one.proyect.Entities.ReparationEntity;
import one.proyect.Entities.Report1;
import one.proyect.Entities.VoucherEntity;
import one.proyect.Entities.VehicleEntity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/voucher")
@CrossOrigin(origins = "*")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    @Autowired
    private ReparationService reparationService;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/report1")
    public List<Report1> getRepote1MountByVehicle() {
        List<Report1> report1 = new ArrayList<>();
        List<VehicleEntity> vehicles = vehicleService.getAllVehicles();
        for (VehicleEntity vehicle : vehicles) {
            List<ReparationEntity> reparations = reparationService.getReparationsByVehicle(vehicle.getId());
            for (ReparationEntity reparation : reparations) {
                VoucherEntity voucher = reparation.getVoucher();
                if (voucher != null) {
                    Report1 report = new Report1(vehicle.getPatent(), reparation.getId().toString(),
                            voucher.getDiscount1().toString(), voucher.getDiscount2().toString(),
                            voucher.getSurcharge1().toString(), voucher.getSurcharge2().toString(),
                            voucher.getTotal_reparations().toString(), voucher.getMount().toString());
                    if (voucher.getDiscount3() != null) {
                        report.setDescount3(voucher.getDiscount3().toString());
                    } else {
                        report.setDescount3("0");
                    }
                    if (voucher.getSurcharge3() != null) {
                        report.setSurcharge3(voucher.getSurcharge3().toString());
                    } else {
                        report.setSurcharge3("0");
                    }

                    report1.add(report);
                } else {
                    Report1 report = new Report1(vehicle.getPatent(), reparation.getId().toString(), "0", "0", "0", "0",
                            "0", "0");
                    report1.add(report);
                }
            }
        }

        return report1;
    }

}
