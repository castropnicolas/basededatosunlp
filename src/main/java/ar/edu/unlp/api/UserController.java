package ar.edu.unlp.api;

import ar.edu.unlp.dto.UserDTO;
import ar.edu.unlp.exceptions.UserUnknownException;
import ar.edu.unlp.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private IUserService usersService;

    public UserController(IUserService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid UserDTO userDTO) throws Exception {
        this.getUsersService().addUser(userDTO.getName(), userDTO.getUsername(), "notevoyadecirmiclave");
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        try {
            this.getUsersService().deleteById(id);
        } catch (IllegalArgumentException i) {
            response.put("mensaje", "Id de usuario inválido.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("mensaje", "¡Usuario eliminado con éxito!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> update(@PathVariable String username, @RequestBody UserDTO dto) {
        UserDTO userDTO = null;
        try {
            userDTO = this.getUsersService().updateUser(username, dto);
        } catch (UserUnknownException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "Nombre de usuario inexistente.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

    public IUserService getUsersService() {
        return this.usersService;
    }

}
