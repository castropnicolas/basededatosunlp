package ar.edu.unlp.service;

import ar.edu.unlp.dto.UserDTO;
import ar.edu.unlp.exceptions.UserUnknownException;
import org.springframework.dao.OptimisticLockingFailureException;

import java.util.Collection;

public interface IUserService {

    UserDTO addUser(String aName, String anUsername, String aPassword) throws Exception;

    Collection<UserDTO> getAllUsers();

    UserDTO findByUsername(String username) throws UserUnknownException;

    UserDTO updateUser(String username, UserDTO userDTO) throws OptimisticLockingFailureException, UserUnknownException;

    Integer numberOfUsers();

    void deleteByUsername(String username) throws IllegalArgumentException, UserUnknownException;
}
