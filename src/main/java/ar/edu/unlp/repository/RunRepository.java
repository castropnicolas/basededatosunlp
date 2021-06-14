package ar.edu.unlp.repository;

import ar.edu.unlp.model.Run;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RunRepository extends JpaRepository<Run, String> {

    Optional<Run> findById(String anId);

}
