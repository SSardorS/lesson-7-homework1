package uz.pdp.homework1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.homework1.entity.USSDcode;

public interface USSDRepository extends JpaRepository<USSDcode, Long> {
}
