package ar.edu.unlp.service;

import ar.edu.unlp.dto.UserDTO;
import ar.edu.unlp.exceptions.UserUnknownException;

import java.util.Collection;

public interface IUserService {

    UserDTO addUser(String aName, String anUsername, String aPassword) throws Exception;

    Collection<UserDTO> getAllUsers();

    UserDTO findByUsername(String username) throws UserUnknownException;

    void deleteByUsername(String username) throws UserUnknownException;

    void deleteById(String id) throws IllegalArgumentException;
}
