package ar.edu.unlp.repository;

import ar.edu.unlp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String anUsername);

    Boolean existsByUsername(String username);

    Long deleteByUsername(String username);

    void deleteById(String id);

}
