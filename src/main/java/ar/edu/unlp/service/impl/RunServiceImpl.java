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

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
public class RunServiceImpl implements IRunService {

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
    public LocationDTO addLocation(String idRun, Double aLatitude, Double aLongitude) throws RunUnknownException {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        Location newLocation = runningApp.addLocationToRun(idRun, aLatitude, aLongitude);
        return this.getDtoFactory().createLocationDTO(newLocation);
    }

    @Override
    public RunDTO addRun(String username) throws UserUnknownException {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        Run aRun = runningApp.addRunToUser(username);
        return this.getDtoFactory().createRunDTO(aRun);
    }

    @Override
    public Collection<RunDTO> findByUsername(String username) throws UserUnknownException {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        Collection<Run> runs = runningApp.findRunsByUser(username);
        Collection<RunDTO> runDTOS = new ArrayList<>();
        runs.forEach(anRun -> runDTOS.add(this.getDtoFactory().createRunDTO(anRun)));
        return runDTOS;
    }

    public RunningAppRepository getRunningAppRepository() {
        return RepositoryLocator.getInstance().getRunningAppRepository();
    }

    public DTOFactory getDtoFactory() {
        return DTOFactory.getInstance();
    }

}
