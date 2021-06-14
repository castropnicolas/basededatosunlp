package ar.edu.unlp.repository;

import ar.edu.unlp.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, String> {

    Optional<Location> findById(String anId);

}
