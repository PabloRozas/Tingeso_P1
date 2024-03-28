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
@Table(name = "vehicle")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patent;
    private String model;
    private String year_production;
    private int number_seats;

    @ManyToOne
    @JoinColumn(name = "id_engine_type")
    private EngineTypeEntity engineType;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private BrandsEntity brand;

    @ManyToOne
    @JoinColumn(name = "id_vehicle_type")
    private VehicleTypeEntity vehicleType;

    @ManyToOne
    @JoinColumn(name = "id_reparation")
    private ReparationEntity reparation;
}