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

    private RunningApp() {
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
        User user = this.getUserRepository().findByUsername(this, username);
        if (user != null) throw new UsernameNotUniqueException();
        User newUser = new User(username, password, name);
        newUser.setCreatedAt(new Date());
        this.getUsers().add(newUser);
        return newUser;
    }

    public User findByUsername(String username) throws UserUnknownException {
        User user = this.getUserRepository().findByUsername(this, username);
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

    public void deleteUserByUsername(String username) throws UserUnknownException {
        User user = this.getUserRepository().findByUsername(this, username);
        if (user == null) throw new UserUnknownException();
        this.getUsers().removeIf(anUser -> anUser.equals(user));
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

    public Location addLocationToRun(String idRun, Double aLongitude, Double aLatitude) throws RunUnknownException {
        Optional<Run> optionalRun = getRunRepository().findById(idRun);
        if (!optionalRun.isPresent()) throw new RunUnknownException();
        Location newLocation = new Location(aLatitude, aLongitude);
        optionalRun.get().addLocation(newLocation);
        return newLocation;
    }

    public Collection<Run> findRunsByUser(String username) throws UserUnknownException {
        User user = this.findByUsername(username);
        if (user == null) throw new UserUnknownException();
        return user.getRuns();
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
        Long numberOfUsers = getUserRepository().count(this);
        return numberOfUsers.intValue();
    }

    public Collection<Location> findLocationsByRun(String id) throws RunUnknownException {
        Optional<Run> aRun = getRunRepository().findById(id);
        if (!aRun.isPresent())
            throw new RunUnknownException();
        return aRun.get().getLocations();
    }
}
