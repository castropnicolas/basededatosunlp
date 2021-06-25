package ar.edu.unlp.api;

import ar.edu.unlp.dto.LocationDTO;
import ar.edu.unlp.dto.RunDTO;
import ar.edu.unlp.exceptions.RunUnknownException;
import ar.edu.unlp.service.IRunService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
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
        RunDTO runDTO = this.getRunService().addRun(username);
        return ResponseEntity.status(HttpStatus.CREATED).body(runDTO);
    }

    @PutMapping("/paused/{id}")
    @ApiOperation("Pausar una carrera")
    public ResponseEntity<?> paused(@PathVariable String id) {
        RunDTO runDTO = null;
        try {
            runDTO = this.getRunService().pausedRun(id);
        } catch (RunUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(runDTO);
    }

    @PutMapping("/closed/{id}")
    @ApiOperation("Cerrar una carrera")
    public ResponseEntity<?> closed(@PathVariable String id) {
        RunDTO runDTO = null;
        try {
            runDTO = this.getRunService().closedRun(id);
        } catch (RunUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(runDTO);
    }

    @PostMapping("/createLocation/{id}")
    @ApiOperation("Agregar ubicación a una carrera")
    public ResponseEntity<?> createLocation(@PathVariable String id, @RequestBody LocationDTO dto) {
        LocationDTO locationDTO = null;
        locationDTO = this.getRunService().addLocation(id, dto.getLatitude(), dto.getLongitude());
        return ResponseEntity.ok().body(locationDTO);
    }

}
