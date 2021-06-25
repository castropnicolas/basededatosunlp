package ar.edu.unlp.repository;

import ar.edu.unlp.model.Run;

import java.util.Optional;

public interface RunRepository {

    Optional<Run> findById(String anId);

}
