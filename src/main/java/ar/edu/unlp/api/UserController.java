package ar.edu.unlp.api;

import ar.edu.unlp.dto.UserDTO;
import ar.edu.unlp.exceptions.UserUnknownException;
import ar.edu.unlp.exceptions.UsernameNotUniqueException;
import ar.edu.unlp.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api("API de usuarios")
@RequestMapping("/user")
public class UserController {

    private IUserService usersService;

    public UserController(IUserService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/create")
    @ApiOperation("Agregar un usuario, el nombre de usuario no se puede repetir")
    public ResponseEntity<?> create(@RequestBody @Valid UserDTO userDTO) throws Exception {
        try {
            userDTO = this.getUsersService().addUser(userDTO.getName(), userDTO.getUsername(), "notevoyadecirmiclave");
        } catch (UsernameNotUniqueException notUniqueException) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El nombre de usuario ya existe, intente con uno distinto");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @GetMapping("/all")
    @ApiOperation("Listar todos los usuarios")
    public ResponseEntity<?> list() {
        Collection<UserDTO> list = this.getUsersService().getAllUsers();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{username}")
    @ApiOperation("Recuperar un usuario a partir de su nombre de usuario")
    public ResponseEntity<?> get(@PathVariable String username) {
        UserDTO userDTO = null;
        try {
            userDTO = this.getUsersService().findByUsername(username);
        } catch (UserUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nombre de usuario inexistente");
        }
        return ResponseEntity.ok().body(userDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Eliminar un usuario a partir de su id")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        try {
            this.getUsersService().deleteById(id);
        } catch (UserUnknownException i) {
            response.put("mensaje", "Id de usuario inexistente.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("mensaje", "¡Usuario eliminado con éxito!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{username}")
    @ApiOperation("Actualizar los datos de un usuario")
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

    @GetMapping("/numberOfUsers")
    @ApiOperation("Devuelve la cantidad de usuarios existentes")
    public Integer numberOfUsers() {
        return this.getUsersService().numberOfUsers();
    }

    public IUserService getUsersService() {
        return this.usersService;
    }

}
