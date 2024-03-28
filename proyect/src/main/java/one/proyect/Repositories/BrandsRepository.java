package one.proyect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.proyect.Entities.BrandsEntity;

public interface BrandsRepository extends JpaRepository<BrandsEntity, Long> {
}