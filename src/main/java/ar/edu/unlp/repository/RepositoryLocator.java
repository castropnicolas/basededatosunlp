package ar.edu.unlp.repository;

public class RepositoryLocator {

    private static RepositoryLocator instance;

    private UserRepository userRepository;
    private RunningAppRepository companyRepository;
    private RunRepository runRepository;
    private LocationRepository locationRepository;

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

    public RunningAppRepository getCompanyRepository() {
        return companyRepository;
    }

    public void setCompanyRepository(RunningAppRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public RunRepository getRunRepository() {
        return runRepository;
    }

    public void setRunRepository(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    public LocationRepository getLocationRepository() {
        return locationRepository;
    }

    public void setLocationRepository(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
}
