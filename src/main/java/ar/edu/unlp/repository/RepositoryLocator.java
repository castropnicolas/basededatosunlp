package ar.edu.unlp.repository;

public class RepositoryLocator {

    private static RepositoryLocator instance;

    private UserRepository userRepository;
    private RunningAppRepository runningAppRepository;
    private RunRepository runRepository;

    private RepositoryLocator() {
    }

    public static RepositoryLocator getInstance() {
        if (instance == null) {
            instance = new RepositoryLocator();
        }
        return instance;
    }

    public UserRepository getUserRepository() {
        return this.userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RunningAppRepository getRunningAppRepository() {
        return runningAppRepository;
    }

    public void setRunningAppRepository(RunningAppRepository runningAppRepository) {
        this.runningAppRepository = runningAppRepository;
    }

    public RunRepository getRunRepository() {
        return runRepository;
    }

    public void setRunRepository(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

}
