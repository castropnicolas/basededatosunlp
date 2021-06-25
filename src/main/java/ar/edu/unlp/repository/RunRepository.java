package ar.edu.unlp.repository;

import ar.edu.unlp.model.Run;
import ar.edu.unlp.model.User;

import java.util.Collection;
import java.util.Optional;

public interface RunRepository {

    Optional<Run> findById(String anId);

    Collection<Run> findAll();
}
