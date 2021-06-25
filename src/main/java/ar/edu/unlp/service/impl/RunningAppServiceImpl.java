package ar.edu.unlp.service.impl;

import ar.edu.unlp.model.RunningApp;
import ar.edu.unlp.repository.RepositoryLocator;
import ar.edu.unlp.repository.RunningAppRepository;
import ar.edu.unlp.service.IRunningAppService;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RunningAppServiceImpl implements IRunningAppService {

    public RunningAppServiceImpl(RunningAppRepository runningAppRepository) {
        RepositoryLocator.getInstance().setRunningAppRepository(runningAppRepository);
    }

    @Override
    public RunningApp findFirstByOrderById() {
        RunningApp runningApp = this.getRunningAppRepository().findFirstByOrderById();
        return runningApp;
    }

    public RunningAppRepository getRunningAppRepository() {
        return RepositoryLocator.getInstance().getRunningAppRepository();
    }
}
