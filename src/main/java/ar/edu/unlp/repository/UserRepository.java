package ar.edu.unlp.repository;

import ar.edu.unlp.model.RunningApp;
import ar.edu.unlp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends UserRepositoryCustom, JpaRepository<User, String> {

    User findByUsername(RunningApp runningApp, String anUsername);

    Long count(RunningApp runningApp);

}
