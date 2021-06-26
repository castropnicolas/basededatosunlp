package ar.edu.unlp.repository;

import ar.edu.unlp.model.RunningApp;
import ar.edu.unlp.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.Optional;

@Repository
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

    @Override
    public Long count(RunningApp runningApp) {
        String countUsers = "SELECT count(*)  FROM users u " +
                "WHERE u.running_app_id = '" + runningApp.getId() + "' ";
        BigInteger count = (BigInteger) entityManager.createNativeQuery(countUsers).getSingleResult();
        return count.longValue();
    }

}
