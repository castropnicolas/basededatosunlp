package ar.edu.unlp.repository;

public class RepositoryLocator {

    private static RepositoryLocator instance;

    private UserRepository userRepository;
    private CompanyRepository companyRepository;

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

    public CompanyRepository getCompanyRepository() {
        return companyRepository;
    }

    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
}
