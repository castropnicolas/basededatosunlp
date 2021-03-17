package ar.edu.unlp.api;

import ar.edu.unlp.dto.UserDTO;
import ar.edu.unlp.model.UserUnknownException;
import ar.edu.unlp.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

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
    public ResponseEntity<?> list() {
        Collection<UserDTO> list = this.getUsersService().getAllUsers();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> get(@PathVariable String username) {
        UserDTO userDTO = null;
        try {
            userDTO = this.getUsersService().findByUsername(username);
        } catch (UserUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(userDTO);
    }


    public IUserService getUsersService() {
        return this.usersService;
    }

}
