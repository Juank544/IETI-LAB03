package co.edu.escuelaing.User.controller;

import co.edu.escuelaing.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Value("$(app.secret)")
    String secret;

    @Autowired
    private UserService userService;
}
