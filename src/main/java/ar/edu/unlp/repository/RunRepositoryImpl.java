package ar.edu.unlp.repository;

import ar.edu.unlp.model.Run;
import ar.edu.unlp.model.RunningApp;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;

@Repository
public class RunRepositoryImpl implements RunRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Run> findById(String anId) {
        return Optional.empty();
    }

    @Override
    public Collection<Run> findAll() {
        return null;
    }
}
