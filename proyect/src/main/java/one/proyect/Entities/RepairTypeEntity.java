package one.proyect.Entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "repair_type")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RepairTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "repairType")
    private Set<PriceEntity> prices = new HashSet<>();

    @ManyToMany(mappedBy = "repairTypes")
    private Set<ReparationEntity> reparations = new HashSet<>();
}
