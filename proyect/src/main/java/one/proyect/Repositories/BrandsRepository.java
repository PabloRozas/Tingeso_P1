package one.proyect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import one.proyect.Entities.BrandsEntity;
import one.proyect.Entities.Report3_2;

import java.util.List;

@Repository
public interface BrandsRepository extends JpaRepository<BrandsEntity, Long> {

        @Query(value = "SELECT b.id, b.name, r.date_admission, r.departure_date\r\n" + //
                        "FROM reparation r \r\n" + //
                        "INNER JOIN vehicle v ON v.id = r.id_vehicle  \r\n" + //
                        "INNER JOIN brands b ON b.id = v.id_brand ", nativeQuery = true)
        List<?> getReport3();

        @Query(value = "SELECT name\r\n" + //
                        "FROM brands b ", nativeQuery = true)
        List<?> getNamesBrands();
}