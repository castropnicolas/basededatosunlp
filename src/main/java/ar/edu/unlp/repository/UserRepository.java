package ar.edu.unlp.repository;

import ar.edu.unlp.model.User;

import java.util.Optional;

public interface UserRepository {

    User findByUsername(String anUsername);

    Boolean existsByUsername(String username);

    Long count();

    void delete(User user);

    Optional<User> findById(String id);
}
