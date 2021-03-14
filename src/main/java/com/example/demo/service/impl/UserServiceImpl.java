package com.example.demo.service.impl;

import com.example.demo.dto.DTOFactory;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.Company;
import com.example.demo.model.User;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.RepositoryLocator;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
