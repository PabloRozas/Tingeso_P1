package one.proyect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.proyect.Entities.PriceEntity;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

}
