package ar.edu.unlp.service.impl;

import ar.edu.unlp.model.Company;
import ar.edu.unlp.repository.CompanyRepository;
import ar.edu.unlp.repository.RepositoryLocator;
import ar.edu.unlp.repository.UserRepository;
import ar.edu.unlp.service.IUserService;
import ar.edu.unlp.dto.DTOFactory;
import ar.edu.unlp.dto.UserDTO;
import ar.edu.unlp.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    public UserServiceImpl(UserRepository userRepository, CompanyRepository companyRepository) {
        RepositoryLocator.getInstance().setUserRepository(userRepository);
        RepositoryLocator.getInstance().setCompanyRepository(companyRepository);
    }

    @Override
    public UserDTO addUser(String aName, String anUsername, String aPassword) throws Exception {
        Company company = this.getCompanyRepository().findFirstByOrderById();
        User newUser = company.addUser(anUsername, aPassword, aName);
        return this.getDtoFactory().createUserDTO(newUser);
    }

    @Override
    public Collection<UserDTO> getAllUsers() {
        Company company = this.getCompanyRepository().findFirstByOrderById();
        Collection<User> users = company.getUsers();
        Collection<UserDTO> userDTOS = new ArrayList<>();
        users.forEach(anUser -> userDTOS.add(this.getDtoFactory().createUserDTO(anUser)));
        return userDTOS;
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
