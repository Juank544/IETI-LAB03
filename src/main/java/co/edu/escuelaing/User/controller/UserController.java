package co.edu.escuelaing.User.controller;

import co.edu.escuelaing.User.data.User;
import co.edu.escuelaing.User.dto.UserDto;
import co.edu.escuelaing.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;
    private final AtomicInteger count = new AtomicInteger(0);
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");

    public UserController(@Autowired UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        try {
            return new ResponseEntity<>(userService.getAll(),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,null,e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable String id ) {
        try {
            return new ResponseEntity<>(userService.findById(id),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,null,e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto ) {
        try {
            LocalDateTime now = LocalDateTime.now();
            User user = new User();
            user.setId(String.valueOf(count.incrementAndGet()));
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setLastName(userDto.getLastName());
            user.setCreatedAt(dtf.format(now));
            userService.create(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,null,e);
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id ) {
        try {
            User user = userService.findById(id);
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setLastName(userDto.getLastName());
            userService.update(user,id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,null,e);
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,null,e);
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
