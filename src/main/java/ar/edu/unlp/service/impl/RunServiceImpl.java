package ar.edu.unlp.service.impl;

import ar.edu.unlp.dto.DTOFactory;
import ar.edu.unlp.dto.LocationDTO;
import ar.edu.unlp.dto.RunDTO;
import ar.edu.unlp.exceptions.RunUnknownException;
import ar.edu.unlp.exceptions.UserUnknownException;
import ar.edu.unlp.model.Location;
import ar.edu.unlp.model.Run;
import ar.edu.unlp.model.RunningApp;
import ar.edu.unlp.repository.RepositoryLocator;
import ar.edu.unlp.repository.RunRepository;
import ar.edu.unlp.repository.RunningAppRepository;
import ar.edu.unlp.service.IRunService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class RunServiceImpl implements IRunService {

    @Override
    public Collection<RunDTO> getAllRuns() {
        Collection<Run> runs = null;
        Collection<RunDTO> runDTOS = new ArrayList<>();
        runs.forEach(anRun -> runDTOS.add(this.getDtoFactory().createRunDTO(anRun)));
        return runDTOS;
    }

    @Override
    public RunDTO pausedRun(String id) throws RunUnknownException {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        Run aRun = runningApp.pausedRun(id);
        return this.getDtoFactory().createRunDTO(aRun);
    }

    @Override
    public RunDTO activeRun(String id) throws RunUnknownException {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        Run aRun = runningApp.activeRun(id);
        return this.getDtoFactory().createRunDTO(aRun);
    }

    @Override
    public RunDTO closedRun(String id) throws RunUnknownException {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        Run aRun = runningApp.closedRun(id);
        return this.getDtoFactory().createRunDTO(aRun);
    }

    @Override
    public RunDTO findById(String id) throws RunUnknownException {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        Run aRun = runningApp.findRunById(id);
        return this.getDtoFactory().createRunDTO(aRun);
    }

    @Override
    public LocationDTO addLocation(String idRun, Double aLatitude, Double aLongitude) {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        Location newLocation = runningApp.addLocationToRun(idRun, aLatitude, aLongitude);
        return this.getDtoFactory().createLocationDTO(newLocation);
    }

    @Override
    public RunDTO addRun(String username) throws UserUnknownException {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        Run aRun = runningApp.addRunToUser(username);
//        RepositoryLocator.getInstance().getRunRepository().save(aRun);
        return this.getDtoFactory().createRunDTO(aRun);
    }

    public RunningAppRepository getRunningAppRepository() {
        return RepositoryLocator.getInstance().getRunningAppRepository();
    }

    public RunRepository getRunRepository() {
        return RepositoryLocator.getInstance().getRunRepository();
    }

    public DTOFactory getDtoFactory() {
        return DTOFactory.getInstance();
    }

}
