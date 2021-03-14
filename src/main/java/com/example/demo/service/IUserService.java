package com.example.demo.service;

import com.example.demo.dto.UserDTO;

public interface IUserService {

    UserDTO addUser(String aName, String anUsername, String aPassword) throws Exception ;

}
