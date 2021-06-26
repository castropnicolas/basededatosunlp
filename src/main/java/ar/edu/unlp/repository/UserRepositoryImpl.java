package ar.edu.unlp.repository;

import ar.edu.unlp.model.RunningApp;
import ar.edu.unlp.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User findByUsername(RunningApp runningApp, String anUsername) {
        String findByUsername = "SELECT *  FROM users u " +
                "WHERE u.username = '" + anUsername + "' " +
                "AND u.running_app_id = '" + runningApp.getId() + "' ";
        Query query = entityManager.createNativeQuery(findByUsername, User.class);
        Optional<User> user = query.getResultList()
                .stream()
                .findFirst();
        return user.isPresent() ? user.get() : null;
    }

}
