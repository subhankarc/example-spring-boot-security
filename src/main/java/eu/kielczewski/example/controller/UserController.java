package eu.kielczewski.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.kielczewski.example.domain.Role;
import eu.kielczewski.example.domain.User;
import eu.kielczewski.example.domain.UserCreateForm;
import eu.kielczewski.example.service.user.UserService;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public User getUserCreatePage() {
        LOGGER.debug("Getting user create form");
        // return new ModelAndView("user_create", "form", new UserCreateForm());
        UserCreateForm form = new UserCreateForm();
        form.setEmail("hello@hello");
        form.setPassword("password");
        form.setRole(Role.ADMIN);
        return userService.create(form);
    }

}
