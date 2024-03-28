package one.proyect.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.proyect.Entities.VoucherEntity;

public interface VoucherRepository extends JpaRepository<VoucherEntity, Long> {

}
