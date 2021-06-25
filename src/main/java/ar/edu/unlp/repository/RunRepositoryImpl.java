package ar.edu.unlp.repository;

import ar.edu.unlp.model.Run;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class RunRepositoryImpl implements RunRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Run> findById(String anId) {
        return Optional.of(entityManager.createQuery("FROM Run r WHERE r.id = :id", Run.class)
                .setParameter("id", anId)
                .setMaxResults(1)
                .getResultList()
                .stream()
                .findFirst()).orElse(Optional.empty());
    }

}
