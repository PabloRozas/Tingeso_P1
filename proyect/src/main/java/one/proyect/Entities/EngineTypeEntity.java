package one.proyect.Entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "engine_type")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EngineTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "engineType")
    private Set<PriceEntity> prices = new HashSet<>();

    @OneToMany(mappedBy = "engineType")
    private Set<DiscountEntity> discounts = new HashSet<>();

    @OneToMany(mappedBy = "engineType")
    private Set<VehicleEntity> vehicles = new HashSet<>();

}
