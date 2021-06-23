package ar.edu.unlp.config.custom;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import liquibase.change.custom.CustomTaskChange;
import liquibase.change.custom.CustomTaskRollback;
import liquibase.database.Database;
import liquibase.exception.CustomChangeException;
import liquibase.exception.RollbackImpossibleException;
import liquibase.exception.SetupException;
import liquibase.exception.ValidationErrors;
import liquibase.ext.mongodb.database.MongoConnection;
import liquibase.resource.ResourceAccessor;
import org.bson.Document;
import org.bson.conversions.Bson;

public class UpsertRunningAppIdChange implements CustomTaskChange, CustomTaskRollback {

    private String collectionName;
    private String runningAppId;

    private ResourceAccessor resourceAccessor;

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public void setRunningAppId(String runningAppId) {
        this.runningAppId = runningAppId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getRunningAppId() {
        return runningAppId;
    }

    public void execute(final Database database) throws CustomChangeException {
        MongoConnection connection = (MongoConnection) database.getConnection();
        MongoCollection<Document> collection = connection.getMongoDatabase().getCollection(getCollectionName());
        Bson updates = Updates.set("runningAppId", getRunningAppId());
        Document filter = new Document();
        collection.updateMany(filter, updates);
    }

    public String getConfirmationMessage() {
        return "RunningAppId upsert-ed to all";
    }

    public void setUp() throws SetupException {

    }

    public void setFileOpener(ResourceAccessor resourceAccessor) {
        this.resourceAccessor = resourceAccessor;
    }

    public ValidationErrors validate(Database database) {
        return new ValidationErrors();
    }

    public void rollback(Database database) throws CustomChangeException, RollbackImpossibleException {
        //TODO: unset the upsert-ed field. Currently do nothing
    }
}
