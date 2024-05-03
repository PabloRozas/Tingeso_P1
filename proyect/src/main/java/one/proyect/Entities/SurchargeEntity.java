package one.proyect.Entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "surcharge")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SurchargeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int percentage;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_vehicle_type")
    private VehicleTypeEntity vehicleType;

    @ManyToOne
    @JoinColumn(name = "id_surcharge_type")
    private SurchargeTypeEntity surchargeType;

    @ManyToMany(mappedBy = "surcharges")
    private Set<VoucherEntity> vouchers = new HashSet<>();
}
