package ar.edu.unlp.service;

import ar.edu.unlp.dto.RunDTO;

import java.util.Collection;

public interface IRunService {

    RunDTO addRun() throws Exception;

    Collection<RunDTO> getAllRuns();
}
