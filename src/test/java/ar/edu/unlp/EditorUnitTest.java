package ar.edu.unlp;

import ar.edu.unlp.model.Editor;
import ar.edu.unlp.model.Run;
import ar.edu.unlp.model.RunningApp;
import ar.edu.unlp.model.User;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

public class EditorUnitTest {

    @Test
    public void givenMongoDB_WhenEntitiesCreated_thenCanBeRetrieved() throws Exception {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ogm-mongodb");
        Editor editor = generateTestData();
        persistTestData(entityManagerFactory, editor);
        loadAndVerifyTestData(entityManagerFactory, editor);
    }

    @Test
    public void givenMongoDB_WhenEntitiesCreated_thenCanBeRetrieved_anUser() throws Exception {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ogm-mongodb");
        RunningApp runningApp = new RunningApp();
        runningApp.setId("a4295f86-6cd0-4f48-acda-080005f3a558");
      /*  User anUser = generateUserTestData();
        runningApp.getUsers().add(anUser);*/
        persistTestDataUser(entityManagerFactory, runningApp);
//        loadAndVerifyTestData(entityManagerFactory, anUser);
    }
    /*@Test
    public void givenNeo4j_WhenEntitiesCreated_thenCanBeRetrieved() throws Exception {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ogm-neo4j");
        Editor editor = generateTestData();
        persistTestData(entityManagerFactory, editor);
        loadAndVerifyTestData(entityManagerFactory, editor);
    }*/

    private void persistTestData(EntityManagerFactory entityManagerFactory, Editor editor) throws Exception {
        TransactionManager transactionManager = com.arjuna.ats.jta.TransactionManager.transactionManager();
        EntityManager entityManager;

        transactionManager.begin();
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(editor);
        entityManager.close();
        transactionManager.commit();
    }

    private void persistTestDataUser(EntityManagerFactory entityManagerFactory, RunningApp runningApp) throws Exception {
        TransactionManager transactionManager = com.arjuna.ats.jta.TransactionManager.transactionManager();
        EntityManager entityManager;

        transactionManager.begin();
        entityManager = entityManagerFactory.createEntityManager();
//        entityManager.persist(runningApp);
        entityManager.merge(runningApp);
        entityManager.close();
        transactionManager.commit();
    }

    private void loadAndVerifyTestData(EntityManagerFactory entityManagerFactory, Editor editor) throws Exception {
        TransactionManager transactionManager = com.arjuna.ats.jta.TransactionManager.transactionManager();
        EntityManager entityManager;

        transactionManager.begin();
        entityManager = entityManagerFactory.createEntityManager();
        Editor loadedEditor = entityManager.find(Editor.class, editor.getEditorId());
        assertThat(loadedEditor).isNotNull();
        assertThat(loadedEditor.getEditorName()).isEqualTo("Tom");
       /* assertThat(loadedEditor.getAssignedAuthors()).onProperty("authorName")
            .containsOnly("Maria", "Mike");
        Map<String, Author> loadedAuthors = loadedEditor.getAssignedAuthors()
            .stream()
            .collect(Collectors.toMap(Author::getAuthorName, e -> e));
        assertThat(loadedAuthors.get("Maria")
            .getAuthoredArticles()).onProperty("articleTitle")
                .containsOnly("Basic of Hibernate OGM");
        assertThat(loadedAuthors.get("Mike")
            .getAuthoredArticles()).onProperty("articleTitle")
                .containsOnly("Intermediate of Hibernate OGM", "Advanced of Hibernate OGM");*/
        entityManager.close();
        transactionManager.commit();
    }

    private Editor generateTestData() {
        Editor tom = new Editor("Tom");
        User newUser = new User("ncastro", "noteladigo", "Nicolas Castro");
        newUser.setCreatedAt(new Date());
        Run anRun = new Run();
        newUser.addRun(anRun);
        /*Author maria = new Author("Maria");
        Author mike = new Author("Mike");
        Article basic = new Article("Basic of Hibernate OGM");
        Article intermediate = new Article("Intermediate of Hibernate OGM");
        Article advanced = new Article("Advanced of Hibernate OGM");
        maria.getAuthoredArticles()
            .add(basic);
        basic.setAuthor(maria);
        mike.getAuthoredArticles()
            .add(intermediate);
        intermediate.setAuthor(mike);
        mike.getAuthoredArticles()
            .add(advanced);
        advanced.setAuthor(mike);
        tom.getAssignedAuthors()
            .add(maria);
        maria.setEditor(tom);
        tom.getAssignedAuthors()
            .add(mike);
        mike.setEditor(tom);*/
        return tom;
    }

    private User generateUserTestData() {
        User newUser = new User("ncastro", "noteladigo", "Nicolas Castro");
        newUser.setCreatedAt(new Date());
        Run anRun = new Run();
        newUser.addRun(anRun);
        return newUser;
    }
}
