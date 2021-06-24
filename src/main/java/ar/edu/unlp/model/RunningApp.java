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

public class RunningApp {

    private String id;

    private Collection<User> users;

    private static RunningApp instance;

    public RunningApp() {
        this.setUsers(new ArrayList<>());
    }

    public static RunningApp getInstance() {
        if (instance == null) {
            instance = new RunningApp();
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

    public User findByUsername(String username) throws UserUnknownException {
        User user = this.getUserRepository().findByUsername(username);
        if (user == null)
            throw new UserUnknownException();
        return user;
    }

    public Run findRunById(String id) throws RunUnknownException {
        Optional<Run> optionalRun = this.getRunRepository().findById(id);
        if (!optionalRun.isPresent())
            throw new RunUnknownException();
        return optionalRun.get();
    }

    public void deleteUserById(String id) throws UserUnknownException {
        Optional<User> user = null;
        if (!user.isPresent())
            throw new UserUnknownException();
//        this.getUserRepository().delete(user.get());
    }

    public Run pausedRun(String anId) throws RunUnknownException {
        Optional<Run> optionalRun = getRunRepository().findById(anId);
        if (!optionalRun.isPresent())
            throw new RunUnknownException();
        optionalRun.get().paused();
        return optionalRun.get();
    }

    public Run activeRun(String anId) throws RunUnknownException {
        Optional<Run> optionalRun = getRunRepository().findById(anId);
        if (!optionalRun.isPresent())
            throw new RunUnknownException();
        optionalRun.get().active();
        return optionalRun.get();
    }

    public Run closedRun(String idRun) throws RunUnknownException {
        Optional<Run> optionalRun = getRunRepository().findById(idRun);
        if (!optionalRun.isPresent())
            throw new RunUnknownException();
        optionalRun.get().closed();
        return optionalRun.get();
    }

    public Location addLocationToRun(String idRun, Double aLongitude, Double aLatitude) {
        Optional<Run> optionalRun = getRunRepository().findById(idRun);
        Location newLocation = new Location(aLatitude, aLongitude);
        optionalRun.get().addLocation(newLocation);
        return newLocation;
    }

    public Run addRunToUser(String username) throws UserUnknownException {
        User anUser = findByUsername(username);
        Run newRun = new Run();
        anUser.addRun(newRun);
        return newRun;
    }

    private UserRepository getUserRepository() {
        return RepositoryLocator.getInstance().getUserRepository();
    }

    private RunRepository getRunRepository() {
        return RepositoryLocator.getInstance().getRunRepository();
    }

    public Integer numberOfUsers() {
        Long numberOfUsers = 0L;
        return numberOfUsers.intValue();
    }
}
