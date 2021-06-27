package ar.edu.unlp.api;

import ar.edu.unlp.dto.LocationDTO;
import ar.edu.unlp.dto.RunDTO;
import ar.edu.unlp.exceptions.RunUnknownException;
import ar.edu.unlp.exceptions.UserUnknownException;
import ar.edu.unlp.service.IRunService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
@Api("API de carreras")
@RequestMapping("/run")
public class RunController {

    private IRunService runService;

    public RunController(IRunService runService) {
        this.runService = runService;
    }

    public IRunService getRunService() {
        return runService;
    }

    @PostMapping("/create")
    @ApiOperation("Agregar una carrera, para un usuario existente")
    public ResponseEntity<?> create(@RequestParam("username") String username) throws Exception {
        RunDTO runDTO = null;
        try {
            runDTO = this.getRunService().addRun(username);
        } catch (UserUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nombre de usuario inexistente");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(runDTO);
    }

    @GetMapping("/all/{username}")
    @ApiOperation("Listar todas las carreras para un usuario")
    public ResponseEntity<?> list(@PathVariable String username) {
        Collection<RunDTO> list = null;
        try {
            list = this.getRunService().findByUsername(username);
        } catch (UserUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nombre de usuario inexistente");
        }
        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/paused/{id}")
    @ApiOperation("Pausar una carrera")
    public ResponseEntity<?> paused(@PathVariable String id) {
        RunDTO runDTO = null;
        try {
            runDTO = this.getRunService().pausedRun(id);
        } catch (RunUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id de carrera inexistente");
        }
        return ResponseEntity.ok().body(runDTO);
    }

    @PutMapping("/closed/{id}")
    @ApiOperation("Finalizar una carrera")
    public ResponseEntity<?> closed(@PathVariable String id) {
        RunDTO runDTO = null;
        try {
            runDTO = this.getRunService().closedRun(id);
        } catch (RunUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id de carrera inexistente");
        }
        return ResponseEntity.ok().body(runDTO);

    }

    @PutMapping("/active/{id}")
    @ApiOperation("Activar una carrera")
    public ResponseEntity<?> active(@PathVariable String id) {
        RunDTO runDTO = null;
        try {
            runDTO = this.getRunService().activeRun(id);
        } catch (RunUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id de carrera inexistente");
        }
        return ResponseEntity.ok().body(runDTO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtener información de una carrera a partir de su id")
    public ResponseEntity<?> get(@PathVariable String id) {
        RunDTO runDTO = null;
        try {
            runDTO = this.getRunService().findById(id);
        } catch (RunUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id de carrera inexistente");
        }
        return ResponseEntity.ok().body(runDTO);
    }

    @PostMapping("/createLocation/{id}")
    @ApiOperation("Agregar ubicación a una carrera")
    public ResponseEntity<?> createLocation(@PathVariable String id, @RequestBody LocationDTO dto) {
        LocationDTO locationDTO = null;
        try {
            locationDTO = this.getRunService().addLocation(id, dto.getLatitude(), dto.getLongitude());
        } catch (RunUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id de carrera inexistente");
        }
        return ResponseEntity.ok().body(locationDTO);
    }

    @GetMapping("/{id}/locations")
    @ApiOperation("Listar ubicaciones para una carrera")
    public ResponseEntity<?> locationsByrun(@PathVariable String id) {
        Collection<LocationDTO> list = null;
        try {
            list = this.getRunService().findLocationsByRun(id);
        } catch (RunUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id de carrera inexistente");
        }
        return ResponseEntity.ok().body(list);
    }

}
