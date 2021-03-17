package ar.edu.unlp.api;

import ar.edu.unlp.dto.UserDTO;
import ar.edu.unlp.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private IUserService usersService;

    public UserController(IUserService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/create")
    public void createUser() throws Exception {
        this.getUsersService().addUser("esteban", "quito", "notevoyadecirmiclave");
    }

    @GetMapping("/all")
    public void getAllUser() throws Exception {
        this.getUsersService().getAllUsers();
        for (UserDTO userDTO : this.getUsersService().getAllUsers()
        ) {
            System.out.println(userDTO.getUsername());
        }
    }

    public IUserService getUsersService() {
        return this.usersService;
    }

}
