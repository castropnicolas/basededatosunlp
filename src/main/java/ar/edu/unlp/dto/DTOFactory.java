package ar.edu.unlp.dto;

import ar.edu.unlp.model.Run;
import ar.edu.unlp.model.User;

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

    public RunDTO createRunDTO(Run anRun) {
        return new RunDTO(anRun.getId(), anRun.getStart(), anRun.getEnd(), anRun.getState());
    }

}
