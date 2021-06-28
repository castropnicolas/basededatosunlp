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
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
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

    /*
     * Bloqueo optimista
     * - Si ya se ha actualizado, se asume que el bloqueo optimista lanzará una excepción, así que
     * capturo la excepción aquí y muestro un mensaje de error.
     * - Si no hay errores, realizo la edición.
     *
     * Para facilitar la lectura del código nombre los objetos como before y after
     *
     * -Al actualizar, se requiere un mecanismo como el bloqueo optimista para evitar la sobrescritura accidental de los cambios realizados por otros usuarios.
     * -Al actualizar, la versión debe ser avanzada y se debe realizar el control de versiones.
     */
    public UserDTO updateUser(String username, UserDTO after) throws OptimisticLockingFailureException, UserUnknownException {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        User before = runningApp.findByUsername(username);
        checkConcurrency(after, before);
        if (after.getUsername() != null) before.setUsername(after.getUsername());
        if (after.getName() != null) before.setName(after.getName());
        return this.getDtoFactory().createUserDTO(before);
    }

    private void checkConcurrency(UserDTO after, User before) {
        if (before.getVersion() != after.getVersion())
            throw new OptimisticLockingFailureException("No hay datos de actualización o ya se han actualizado");
    }

    @Override
    public void deleteByUsername(String username) throws UserUnknownException {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        runningApp.deleteUserByUsername(username);
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
