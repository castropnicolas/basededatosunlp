package ar.edu.unlp.service;

import ar.edu.unlp.dto.LocationDTO;
import ar.edu.unlp.dto.RunDTO;
import ar.edu.unlp.exceptions.RunUnknownException;

public interface IRunService {

    RunDTO pausedRun(String id) throws RunUnknownException;

    RunDTO activeRun(String id) throws RunUnknownException;

    RunDTO closedRun(String id) throws RunUnknownException;

    RunDTO findById(String id) throws RunUnknownException;

    LocationDTO addLocation(String idRun, Double aLatitude, Double aLongitude);

    RunDTO addRun(String username) throws Exception;

}
