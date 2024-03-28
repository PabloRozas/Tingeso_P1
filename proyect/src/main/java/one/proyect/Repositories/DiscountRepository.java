package one.proyect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.proyect.Entities.DiscountEntity;

public interface DiscountRepository extends JpaRepository<DiscountEntity, Long> {

}
