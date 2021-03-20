package ar.edu.unlp.model;

import ar.edu.unlp.repository.RepositoryLocator;
import ar.edu.unlp.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class Company {

    private UUID id;

    private Collection<User> users;

    private static Company instance;

    private Company() {
        this.setUsers(new ArrayList<>());
    }

    public static Company getInstance() {
        if (instance == null) {
            instance = new Company();
        }
        return instance;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
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

    private UserRepository getUserRepository() {
        return RepositoryLocator.getInstance().getUserRepository();
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

    public void deleteById(String id) throws IllegalArgumentException {
        try {
            UUID uid = UUID.fromString(id);
            this.getUserRepository().deleteById(uid);
        }
        catch(IllegalArgumentException i) {
            throw new IllegalArgumentException("Id de usuario inválido");
        }

    }
}
