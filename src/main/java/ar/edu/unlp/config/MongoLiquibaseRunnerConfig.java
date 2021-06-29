package ar.edu.unlp.config;

import liquibase.database.DatabaseFactory;
import liquibase.exception.DatabaseException;
import liquibase.ext.mongodb.database.MongoLiquibaseDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoLiquibaseRunnerConfig {
    public final String url = "mongodb://localhost:27017/liquibaseagain?socketTimeoutMS=1000&connectTimeoutMS=1000&serverSelectionTimeoutMS=1000";

    @Bean
    public MongoLiquibaseRunner liquibaseRunner(final MongoLiquibaseDatabase database) {
        return new MongoLiquibaseRunner(database);
    }

    /**
     * @return Database with connection
     * @throws DatabaseException when cannot connect
     */
    @Bean
    public MongoLiquibaseDatabase database() throws DatabaseException {
        return (MongoLiquibaseDatabase) DatabaseFactory.getInstance().openDatabase(url, null, null, null, null);
    }

}