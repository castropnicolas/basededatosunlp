package ar.edu.unlp.repository;

import ar.edu.unlp.model.RunningApp;
import ar.edu.unlp.model.User;

public interface UserRepositoryCustom {

    User findByUsername(RunningApp runningApp, String anUsername);

    Long count(RunningApp runningApp);

}
