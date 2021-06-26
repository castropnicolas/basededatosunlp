package ar.edu.unlp;

import ar.edu.unlp.model.RunningApp;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

public class EditorUnitTest {

    @Test
    public void givenMongoDB_WhenEntitiesCreated_thenCanBeRetrieved_anUser() throws Exception {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ogm-mongodb");
        RunningApp runningApp = RunningApp.getInstance();
        persistTestData(entityManagerFactory, runningApp);
    }

    private void persistTestData(EntityManagerFactory entityManagerFactory, RunningApp runningApp) throws Exception {
        TransactionManager transactionManager = com.arjuna.ats.jta.TransactionManager.transactionManager();
        EntityManager entityManager;
        transactionManager.begin();
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(runningApp);
        entityManager.close();
        transactionManager.commit();
    }


}
