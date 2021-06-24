package ar.edu.unlp.repository;

import ar.edu.unlp.model.Run;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RunRepository extends MongoRepository<Run, String> {

//public interface RunRepository {

    Optional<Run> findById(String anId);

}
