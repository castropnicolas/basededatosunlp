package ar.edu.unlp.service;

import ar.edu.unlp.dto.UserDTO;
import ar.edu.unlp.model.UserUnknownException;

import java.util.Collection;

public interface IUserService {

    UserDTO addUser(String aName, String anUsername, String aPassword) throws Exception;

    Collection<UserDTO> getAllUsers();

    UserDTO findByUsername(String username) throws UserUnknownException;

}
