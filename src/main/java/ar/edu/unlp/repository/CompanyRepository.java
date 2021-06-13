package ar.edu.unlp.repository;

import ar.edu.unlp.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {

    Company findFirstByOrderById();
}
