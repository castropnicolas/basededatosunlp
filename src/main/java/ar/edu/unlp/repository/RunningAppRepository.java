package ar.edu.unlp.repository;

import ar.edu.unlp.model.RunningApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RunningAppRepository extends JpaRepository<RunningApp, String> {

    RunningApp findFirstByOrderById();
}
