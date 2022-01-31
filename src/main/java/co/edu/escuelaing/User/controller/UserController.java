package co.edu.escuelaing.User.controller;

import co.edu.escuelaing.User.data.User;
import co.edu.escuelaing.User.dto.UserDto;
import co.edu.escuelaing.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        //TODO implement this method using UserService
        return null;
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable String id ) {
        //TODO implement this method using UserService
        return null;
    }


    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto ) {
        //TODO implement this method using UserService
        return null;
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id ) {
        //TODO implement this method using UserService
        return null;
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        //TODO implement this method using UserService
        return null;
    }
}
