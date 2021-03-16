package ar.edu.unlp.repository;

import ar.edu.unlp.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {

    Company findFirstByOrderById();
}
