package one.proyect.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "reparation_repair_type", joinColumns = @JoinColumn(name = "reparation_id"), inverseJoinColumns = @JoinColumn(name = "repair_type_id"))
    private Set<RepairTypeEntity> repairTypes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_vehicle")
    private VehicleEntity vehicle;

    @ManyToOne
    @JoinColumn(name = "id_voucher")
    private VoucherEntity voucher;
}
