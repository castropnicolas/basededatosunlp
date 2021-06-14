package ar.edu.unlp.service;

import ar.edu.unlp.dto.LocationDTO;
import ar.edu.unlp.dto.RunDTO;
import ar.edu.unlp.exceptions.RunUnknownException;

import java.util.Collection;

public interface IRunService {

    RunDTO addRun() throws Exception;

    Collection<RunDTO> getAllRuns();

    RunDTO pausedRun(String id) throws RunUnknownException;

    RunDTO activeRun(String id) throws RunUnknownException;

    RunDTO closedRun(String id) throws RunUnknownException;

    RunDTO findById(String id) throws RunUnknownException;

    LocationDTO addLocation(String idRun, Double aLongitude, Double aLatitude);
}
