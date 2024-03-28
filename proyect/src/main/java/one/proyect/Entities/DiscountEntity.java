package one.proyect.Entities;

import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "discount")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DiscountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int percentage;

    @ManyToOne
    @JoinColumn(name = "discount_type_id")
    private DiscountTypeEntity discountType;

    @ManyToMany(mappedBy = "discounts")
    private Set<VoucherEntity> vouchers = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_engine_type")
    private EngineTypeEntity engineType;
}
