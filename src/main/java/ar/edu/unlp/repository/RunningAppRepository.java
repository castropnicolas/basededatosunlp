package ar.edu.unlp.repository;

import ar.edu.unlp.model.RunningApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunningAppRepository extends JpaRepository<RunningApp, String> {

    RunningApp findFirstByOrderById();
}
