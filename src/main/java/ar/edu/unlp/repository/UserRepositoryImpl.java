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
    public User findByUsername(RunningApp runningApp, String anUsername) {
        String query = "db.users.find({'username' :':username'," +
                "'running_app_id' : ':runningApp' })";
        query = query.replace(":username", anUsername);
        query = query.replace(":runningApp", runningApp.getId());
        Optional<User> user = Optional.of(entityManager.createNativeQuery(query, User.class)
                .getResultList()
                .stream()
                .findFirst())
                .orElse(Optional.empty());
        return user.isPresent() ? user.get() : null;
    }

    @Override
    public Long count(RunningApp runningApp) {
        String query = "db.users.count({'running_app_id':':runningApp' })";
        query = query.replace(":runningApp", runningApp.getId());
        Long count = (Long) entityManager.createNativeQuery(query).getSingleResult();
        return count;
    }

}
