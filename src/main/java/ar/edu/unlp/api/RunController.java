package ar.edu.unlp.api;

import ar.edu.unlp.dto.LocationDTO;
import ar.edu.unlp.dto.RunDTO;
import ar.edu.unlp.dto.UserDTO;
import ar.edu.unlp.exceptions.RunUnknownException;
import ar.edu.unlp.service.IRunService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Collection;

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

   /* @GetMapping("/create")
    public void createRun() throws Exception {
        this.getRunService().addRun();
    }*/

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestParam("idUser")  String idUser) throws Exception {
        RunDTO runDTO = this.getRunService().addRun(idUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(runDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<?> list() {
        Collection<RunDTO> list = this.getRunService().getAllRuns();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/paused/{id}")
    public ResponseEntity<?> paused(@PathVariable String id) {
        RunDTO runDTO = null;
        try {
            runDTO = this.getRunService().pausedRun(id);
        } catch (RunUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(runDTO);
    }

    @GetMapping("/closed/{id}")
    public ResponseEntity<?> closed(@PathVariable String id) {
        RunDTO runDTO = null;
        try {
            runDTO = this.getRunService().closedRun(id);
        } catch (RunUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(runDTO);

    }

    @GetMapping("/active/{id}")
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
    public ResponseEntity<?> get(@PathVariable String id) {
        RunDTO runDTO = null;
        try {
            runDTO = this.getRunService().findById(id);
        } catch (RunUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(runDTO);
    }

    @GetMapping("/createLocation/{id}")
    public ResponseEntity<?> createLocation(@PathVariable String id) {
        LocationDTO locationDTO = null;
        locationDTO = this.getRunService().addLocation(id, 10D, 15D);
        return ResponseEntity.ok().body(locationDTO);
    }

}
