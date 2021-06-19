package ar.edu.unlp.repository;

import ar.edu.unlp.model.RunningApp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RunningAppRepository extends MongoRepository<RunningApp, String> {

    RunningApp findFirstByOrderById();
}
