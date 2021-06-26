package ar.edu.unlp.repository;

import ar.edu.unlp.model.RunningApp;
import ar.edu.unlp.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    User findByUsername(RunningApp runningApp, String anUsername) {

        String query = "db.users.find({'username' :'pcastro' })";
        query = query.replace(":username", anUsername);
        Long count = (Long) entityManager.createNativeQuery(query).getSingleResult();
        return count > 0;

        return entityManager.createQuery(
                "FROM User u where u.username = :username", User.class)
                .setParameter("username", anUsername)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Long count(RunningApp runningApp) {
        Integer count = (Integer) entityManager.createQuery("SELECT COUNT(u) FROM User u").getSingleResult();
        return count.longValue();
    }

}
