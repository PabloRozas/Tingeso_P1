package one.proyect.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.proyect.Entities.BrandsEntity;
import one.proyect.Entities.Report3;
import one.proyect.Entities.Report3_2;
import one.proyect.Repositories.BrandsRepository;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.time.ZoneId;

@Service
public class BrandsService {

    @Autowired
    private BrandsRepository brandsRepository;

    public BrandsEntity getBrandById(Long id) {
        return brandsRepository.findById(id).orElse(null);
    }

    public List<BrandsEntity> getAllBrands() {
        return brandsRepository.findAll();
    }

    public List<Report3> getReport3() {
        List<?> report3 = brandsRepository.getReport3();
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH" + report3);
        List<Report3> report = new ArrayList<>();
        List<Report3_2> report2 = new ArrayList<>();
        for (Object object : report3) {
            Object[] obj = (Object[]) object;
            // Se pasan las pocisiones 2 y 3 a tipo de dato de fecha
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = new Date();
            Date date2 = new Date();
            try {
                date1 = sdf.parse(obj[2].toString());
                date2 = sdf.parse(obj[3].toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Report3_2 report3_ = new Report3_2(obj[0].toString(), obj[1].toString(),
                    date1, date2);
            report2.add(report3_);
        }

        List<?> namesBrands = brandsRepository.getNamesBrands();

        Long count_days_repair = 0L;
        Integer count_reparations = 0;
        // Se hace el match entre los nombres de las marcas y los nombres de las marcas
        // del reporte
        for (Object object : namesBrands) {
            for (Report3_2 report3_ : report2) {
                if (object.toString().equals(report3_.getBrand())) {
                    // Se pasan los dates a LocalDate para poder hacer la resta de dias
                    LocalDate date1 = report3_.getDateAdmission().toInstant().atZone(ZoneId.systemDefault())
                            .toLocalDate();
                    LocalDate date2 = report3_.getDepartureDate().toInstant().atZone(ZoneId.systemDefault())
                            .toLocalDate();

                    Long diff_days = java.time.temporal.ChronoUnit.DAYS.between(date1, date2);
                    count_days_repair += diff_days;
                    count_reparations++;

                }
            }
            if (count_reparations == 0) {
                count_reparations = 1;
            }
            report.add(new Report3(object.toString(), String.valueOf(count_days_repair / count_reparations)));
            count_days_repair = 0L;
            count_reparations = 0;
        }
        return report;
    }
}
