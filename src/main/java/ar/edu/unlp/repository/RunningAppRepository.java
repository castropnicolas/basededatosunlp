package ar.edu.unlp.repository;

import ar.edu.unlp.model.RunningApp;

public interface RunningAppRepository {

    RunningApp findFirstByOrderById();
}
