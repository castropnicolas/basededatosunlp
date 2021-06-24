package ar.edu.unlp.repository;

import ar.edu.unlp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
//public interface UserRepository {
//public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String anUsername);

    Boolean existsByUsername(String username);

    void deleteById(String id);

}
