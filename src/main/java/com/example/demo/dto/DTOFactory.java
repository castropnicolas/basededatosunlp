package com.example.demo.dto;

import com.example.demo.model.User;

public class DTOFactory {

    private static DTOFactory instance;

    private DTOFactory() {
        super();
    }

    public static DTOFactory getInstance() {
        if (instance == null) {
            instance = new DTOFactory();
        }
        return instance;
    }

    public UserDTO createUserDTO(User anUser) {
        return new UserDTO(anUser.getId(), anUser.getUsername(), anUser.getName());
    }

}
