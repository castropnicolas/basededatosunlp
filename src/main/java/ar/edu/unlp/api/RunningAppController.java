package ar.edu.unlp.api;

import ar.edu.unlp.model.RunningApp;
import ar.edu.unlp.service.IRunningAppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("API de usuarios")
@RequestMapping("/running")
public class RunningAppController {

    private IRunningAppService runningAppService;

    public RunningAppController(IRunningAppService runningAppService) {
        this.runningAppService = runningAppService;
    }

    @GetMapping
    @ApiOperation("Obtener running app")
    public ResponseEntity<?> list() {
        RunningApp runningApp = getRunningAppService().findFirstByOrderById();
        return ResponseEntity.ok().body(runningApp);
    }

    public IRunningAppService getRunningAppService() {
        return this.runningAppService;
    }

}
