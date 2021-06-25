package ar.edu.unlp.repository;

import ar.edu.unlp.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByUsername(String anUsername) {
        return entityManager.createQuery("FROM User u where u.username = :username", User.class)
                .setParameter("username", anUsername)
                .getSingleResult();
    }

    @Override
    public Boolean existsByUsername(String anUsername) {
        /*"select case when (count(u) > 0) then true else false end
        from User u where u.username = :username";*/
        Query query = entityManager.createQuery(
                "select (count(u) > 0)" +
                        " from User u where u.username = :username")
                .setParameter("username", anUsername);
/*        TypedQuery<Boolean> query = entityManager.createQuery(
                "SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END " +
                        "FROM User u WHERE u.username = :username", Boolean.class)
                .setParameter("username", anUsername);*/
        return true;
//        return query.getSingleResult();
    }

    @Override
    public void deleteById(String id) {

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
       /* String q = "{ $query : { _id : { $eq:ObjectId(':id') }}}";
        OgmSession session = entityManager.unwrap(OgmSession.class);
        String queryString = session.createNativeQuery(q).getQueryString();
        queryString = queryString.replace( ":id", id );
        Query query = entityManager.createNativeQuery( queryString, User.class );
        return Optional.of(query.getSingleResult());*/
//        return Optional.empty();
        return Optional.of(entityManager.createQuery("FROM User u WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getResultList()
                .stream()
                .findFirst()).orElse(Optional.empty());
    }
}
