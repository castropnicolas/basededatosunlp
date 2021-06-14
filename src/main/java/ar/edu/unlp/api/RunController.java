package ar.edu.unlp.api;

import ar.edu.unlp.dto.RunDTO;
import ar.edu.unlp.service.IRunService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/run")
public class RunController {

    private IRunService runService;

    public RunController(IRunService runService) {
        this.runService = runService;
    }

    @GetMapping("/create")
    public void createRun() throws Exception {
        this.getRunService().addRun();
    }

    public IRunService getRunService() {
        return runService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> list() {
        Collection<RunDTO> list = this.getRunService().getAllRuns();
        return ResponseEntity.ok().body(list);
    }

}
