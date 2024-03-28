package one.proyect.Entities;

import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "voucher")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VoucherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer mount;

    @ManyToMany
    @JoinTable(name = "voucher_discount", joinColumns = @JoinColumn(name = "voucher_id"), inverseJoinColumns = @JoinColumn(name = "discount_id"))
    private Set<DiscountEntity> discounts = new HashSet<>();

    @OneToMany(mappedBy = "voucher")
    private Set<ReparationEntity> reparations = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "voucher_surcharge", joinColumns = @JoinColumn(name = "voucher_id"), inverseJoinColumns = @JoinColumn(name = "surcharge_id"))
    private Set<SurchargeEntity> surcharges = new HashSet<>();

}
