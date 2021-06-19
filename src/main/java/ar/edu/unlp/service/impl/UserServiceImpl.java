package ar.edu.unlp.service.impl;

import ar.edu.unlp.dto.DTOFactory;
import ar.edu.unlp.dto.UserDTO;
import ar.edu.unlp.exceptions.UserUnknownException;
import ar.edu.unlp.model.RunningApp;
import ar.edu.unlp.model.User;
import ar.edu.unlp.repository.RepositoryLocator;
import ar.edu.unlp.repository.RunRepository;
import ar.edu.unlp.repository.RunningAppRepository;
import ar.edu.unlp.repository.UserRepository;
import ar.edu.unlp.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserServiceImpl implements IUserService {

    public UserServiceImpl(UserRepository userRepository, RunningAppRepository runningAppRepository, RunRepository runRepository) {
        RepositoryLocator.getInstance().setUserRepository(userRepository);
        RepositoryLocator.getInstance().setRunningAppRepository(runningAppRepository);
        RepositoryLocator.getInstance().setRunRepository(runRepository);
    }

    @Override
    public UserDTO addUser(String aName, String anUsername, String aPassword) throws Exception {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        User newUser = runningApp.addUser(anUsername, aPassword, aName);
        return this.getDtoFactory().createUserDTO(newUser);
    }

    @Override
    public Collection<UserDTO> getAllUsers() {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        Collection<User> users = runningApp.getUsers();
        Collection<UserDTO> userDTOS = new ArrayList<>();
        users.forEach(anUser -> userDTOS.add(this.getDtoFactory().createUserDTO(anUser)));
        return userDTOS;
    }

    @Override
    public UserDTO findByUsername(String username) throws UserUnknownException {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        User user = runningApp.findByUsername(username);
        return this.getDtoFactory().createUserDTO(user);
    }

    @Override
    public UserDTO updateUser(String username, UserDTO userDTO) throws UserUnknownException {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        User user = runningApp.findByUsername(username);
        if (userDTO.getUsername() != null) user.setUsername(userDTO.getUsername());
        if (userDTO.getName() != null) user.setName(userDTO.getName());
        return this.getDtoFactory().createUserDTO(user);
    }

    @Override
    public void deleteById(String id) throws UserUnknownException {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        runningApp.deleteUserById(id);
    }

    @Override
    public Integer numberOfUsers() {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        return runningApp.numberOfUsers();
    }

    public RunningAppRepository getRunningAppRepository() {
        return RepositoryLocator.getInstance().getRunningAppRepository();
    }

    public DTOFactory getDtoFactory() {
        return DTOFactory.getInstance();
    }

}
