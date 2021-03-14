package com.example.demo.api;

import com.example.demo.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private IUserService usersService;

    public DemoController(IUserService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/create")
    public void createUser() throws Exception {
        this.getUsersService().addUser("esteban", "quito", "notevoyadecirmiclave");
    }

    public IUserService getUsersService() {
        return this.usersService;
    }

}
