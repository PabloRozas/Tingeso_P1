package one.proyect.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
