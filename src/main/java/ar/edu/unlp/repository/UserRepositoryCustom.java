package ar.edu.unlp.repository;

import ar.edu.unlp.model.RunningApp;
import ar.edu.unlp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryCustom {

    User findByUsername(RunningApp runningApp, String anUsername);

}
