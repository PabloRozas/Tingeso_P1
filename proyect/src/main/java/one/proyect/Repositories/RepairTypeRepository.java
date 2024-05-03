package one.proyect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import one.proyect.Entities.RepairTypeEntity;

public interface RepairTypeRepository extends JpaRepository<RepairTypeEntity, Long> {
    @Query(value = "SELECT rt.name as name_type_repair,  COUNT(rrt.repair_type_id) as total_reparations, SUM(p.price) AS total_mount\r\n"
            + //
            "FROM repair_type rt \r\n" + //
            "INNER JOIN price p ON rt.id = p.id_repair_type \r\n" + //
            "INNER JOIN reparation_repair_type rrt ON p.id_repair_type = rrt.repair_type_id\r\n" + //
            "INNER JOIN reparation r ON rrt.reparation_id = r.id\r\n" + //
            "INNER JOIN vehicle v ON r.id_vehicle = v.id\r\n" + //
            "INNER JOIN vehicle_type vt ON v.id_vehicle_type = vt.id\r\n" + //
            "WHERE vt.id = :id_vehicle_type and p.id_engine_type = v.id_engine_type \r\n" + //
            "GROUP BY rrt.repair_type_id\r\n" + //
            "ORDER BY total_mount DESC ", nativeQuery = true)
    List<?> getReport2(@Param("id_vehicle_type") Long id_vehicle_type);

    @Query(value = "SELECT rt.name as name_type_repair,  COUNT(rrt.repair_type_id) as total_reparations, SUM(p.price) AS total_mount\r\n"
            + //
            "FROM repair_type rt \r\n" + //
            "INNER JOIN price p ON rt.id = p.id_repair_type \r\n" + //
            "INNER JOIN reparation_repair_type rrt ON p.id_repair_type = rrt.repair_type_id\r\n" + //
            "INNER JOIN reparation r ON rrt.reparation_id = r.id\r\n" + //
            "INNER JOIN vehicle v ON r.id_vehicle = v.id\r\n" + //
            "INNER JOIN engine_type et ON v.id_engine_type  = et.id\r\n" + //
            "WHERE et.id = :id_engine_type and p.id_engine_type = v.id_engine_type \r\n" + //
            "GROUP BY rrt.repair_type_id\r\n" + //
            "ORDER BY total_mount DESC ", nativeQuery = true)
    List<?> getReport4(@Param("id_engine_type") Long id_vehicle_type);
}