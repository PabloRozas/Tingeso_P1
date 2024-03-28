package one.proyect.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reparation")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReparationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date_admission;
    private String entry_time;
    private String departure_date;
    private String departure_time;
    private String retirement_time;
    private String retirement_date;

    @ManyToOne
    @JoinColumn(name = "id_repair_type")
    private RepairTypeEntity repairType;

    @ManyToOne
    @JoinColumn(name = "id_vehicle")
    private VehicleEntity vehicle;

    @ManyToOne
    @JoinColumn(name = "id_voucher")
    private VoucherEntity voucher;
}
