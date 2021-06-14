package ar.edu.unlp.service.impl;

import ar.edu.unlp.dto.DTOFactory;
import ar.edu.unlp.dto.RunDTO;
import ar.edu.unlp.exceptions.RunUnknownException;
import ar.edu.unlp.exceptions.UserUnknownException;
import ar.edu.unlp.model.Company;
import ar.edu.unlp.model.Run;
import ar.edu.unlp.repository.CompanyRepository;
import ar.edu.unlp.repository.RepositoryLocator;
import ar.edu.unlp.repository.UserRepository;
import ar.edu.unlp.service.IRunService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
public class RunServiceImpl implements IRunService {

    @Override
    public RunDTO addRun() throws Exception {
        Company company = this.getCompanyRepository().findFirstByOrderById();
        Run newRun = company.addRun();
        return this.getDtoFactory().createRunDTO(newRun);
    }

    @Override
    public Collection<RunDTO> getAllRuns() {
        Company company = this.getCompanyRepository().findFirstByOrderById();
        Collection<Run> runs = company.getRuns();
        Collection<RunDTO> runDTOS = new ArrayList<>();
        runs.forEach(anRun -> runDTOS.add(this.getDtoFactory().createRunDTO(anRun)));
        return runDTOS;
    }

    @Override
    public RunDTO pausedRun(String id) throws RunUnknownException {
        Company company = this.getCompanyRepository().findFirstByOrderById();
        Run newRun = company.pausedRun(id);
        return this.getDtoFactory().createRunDTO(newRun);
    }

    @Override
    public RunDTO activeRun(String id) throws RunUnknownException {
        Company company = this.getCompanyRepository().findFirstByOrderById();
        Run newRun = company.activeRun(id);
        return this.getDtoFactory().createRunDTO(newRun);
    }

    @Override
    public RunDTO closedRun(String id) throws RunUnknownException {
        Company company = this.getCompanyRepository().findFirstByOrderById();
        Run newRun = company.closedRun(id);
        return this.getDtoFactory().createRunDTO(newRun);
    }

    public UserRepository getUserRepository() {
        return RepositoryLocator.getInstance().getUserRepository();
    }

    public CompanyRepository getCompanyRepository() {
        return RepositoryLocator.getInstance().getCompanyRepository();
    }

    public DTOFactory getDtoFactory() {
        return DTOFactory.getInstance();
    }

}