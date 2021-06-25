package ar.edu.unlp.repository;

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
    public User findByUsername(String anUsername) {
        return entityManager.createQuery(
                "FROM User u where u.username = :username", User.class)
                .setParameter("username", anUsername)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Boolean existsByUsername(String anUsername) {
        String query = "db.users.count({'username' :':username' })";
        query = query.replace(":username", anUsername);
        Long count = (Long) entityManager.createNativeQuery(query).getSingleResult();
        return count > 0;
    }

    @Override
    public Long count() {
        Integer count = (Integer) entityManager.createQuery("SELECT COUNT(u) FROM User u").getSingleResult();
        return count.longValue();
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.of(entityManager.createQuery("FROM User u WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getResultList()
                .stream()
                .findFirst()).orElse(Optional.empty());
    }
}
