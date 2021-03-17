package ar.edu.unlp.service;

import ar.edu.unlp.dto.UserDTO;

public interface IUserService {

    UserDTO addUser(String aName, String anUsername, String aPassword) throws Exception;

}
