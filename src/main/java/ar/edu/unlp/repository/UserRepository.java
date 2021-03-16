package ar.edu.unlp.repository;

import ar.edu.unlp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String anUsername);

    Boolean existsByUsername(String username);

}
