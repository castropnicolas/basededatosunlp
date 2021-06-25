package ar.edu.unlp.repository;

import ar.edu.unlp.model.RunningApp;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RunningAppRepositoryImpl implements RunningAppRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public RunningApp findFirstByOrderById() {
        return entityManager.createQuery("SELECT ra FROM RunningApp ra", RunningApp.class)
                .getResultList()
                .stream()
                .findFirst()
                .get();
    }

}
