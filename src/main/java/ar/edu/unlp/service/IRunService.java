package ar.edu.unlp.service;

import ar.edu.unlp.dto.LocationDTO;
import ar.edu.unlp.dto.RunDTO;
import ar.edu.unlp.exceptions.RunUnknownException;
import ar.edu.unlp.exceptions.UserUnknownException;

import java.util.Collection;

public interface IRunService {

    RunDTO pausedRun(String id) throws RunUnknownException;

    RunDTO activeRun(String id) throws RunUnknownException;

    RunDTO closedRun(String id) throws RunUnknownException;

    RunDTO findById(String id) throws RunUnknownException;

    LocationDTO addLocation(String idRun, Double aLatitude, Double aLongitude) throws RunUnknownException;

    RunDTO addRun(String username) throws Exception;

    Collection<RunDTO> findByUsername(String username) throws UserUnknownException;

    Collection<LocationDTO> findLocationsByRun(String id) throws RunUnknownException;
}
