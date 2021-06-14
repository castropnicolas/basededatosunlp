package ar.edu.unlp.model;

import ar.edu.unlp.exceptions.RunUnknownException;
import ar.edu.unlp.exceptions.UserUnknownException;
import ar.edu.unlp.exceptions.UsernameNotUniqueException;
import ar.edu.unlp.repository.RepositoryLocator;
import ar.edu.unlp.repository.RunRepository;
import ar.edu.unlp.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class Company {

    private String id;

    private Collection<User> users;

    private Collection<Run> runs;

    private static Company instance;

    private Company() {
        this.setUsers(new ArrayList<>());
        this.setRuns(new ArrayList<>());
    }

    public static Company getInstance() {
        if (instance == null) {
            instance = new Company();
        }
        return instance;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<User> getUsers() {
        return this.users;
    }

    private void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Collection<Run> getRuns() {
        return runs;
    }

    public void setRuns(Collection<Run> runs) {
        this.runs = runs;
    }

    public User addUser(String username, String password, String name) throws UsernameNotUniqueException {
        if (!this.getUserRepository().existsByUsername(username)) {
            User newUser = new User(username, password, name);
            newUser.setCreatedAt(new Date());
            this.getUsers().add(newUser);
            return newUser;
        } else {
            throw new UsernameNotUniqueException();
        }
    }

    public User addUser(User user) throws UsernameNotUniqueException {
        if (!this.getUserRepository().existsByUsername(user.getUsername())) {
            User newUser = new User(user.getUsername(), user.getPassword(), user.getName());
            this.getUsers().add(newUser);
            return newUser;
        } else {
            throw new UsernameNotUniqueException();
        }
    }

    public Run addRun() {
        Run newRun = new Run();
        this.getRuns().add(newRun);
        return newRun;
    }

    public void addRun(Run run) {
        this.getRuns().add(run);
    }

    public User findByUsername(String username) throws UserUnknownException {
        User user = this.getUserRepository().findByUsername(username);
        if (user == null)
            throw new UserUnknownException();
        return user;
    }

    public void deleteByUsername(String username) throws UserUnknownException {
        Long amount = this.getUserRepository().deleteByUsername(username);
        if (amount == 0) throw new UserUnknownException();
    }

    public void deleteUserById(String id) throws IllegalArgumentException {
        try {
            this.getUserRepository().deleteById(id);
        } catch (IllegalArgumentException i) {
            throw new IllegalArgumentException("Id de usuario inválido");
        }
    }

    public Run pausedRun(String anId) throws RunUnknownException {
        Optional<Run> aRun = getRunRepository().findById(anId);
        if (!aRun.isPresent())
            throw new RunUnknownException();
        aRun.get().paused();
        return aRun.get();
    }

    public Run activeRun(String anId) throws RunUnknownException {
        Optional<Run> aRun = getRunRepository().findById(anId);
        if (!aRun.isPresent())
            throw new RunUnknownException();
        aRun.get().active();
        return aRun.get();
    }

    public Run closedRun(String anId) throws RunUnknownException {
        Optional<Run> aRun = getRunRepository().findById(anId);
        if (!aRun.isPresent())
            throw new RunUnknownException();
        aRun.get().closed();
        return aRun.get();
    }

    private UserRepository getUserRepository() {
        return RepositoryLocator.getInstance().getUserRepository();
    }

    private RunRepository getRunRepository() {
        return RepositoryLocator.getInstance().getRunRepository();
    }
}
