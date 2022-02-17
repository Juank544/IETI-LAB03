package co.edu.escuelaing.User.service.impl;

import co.edu.escuelaing.User.data.User;
import co.edu.escuelaing.User.repository.UserRepository;
import co.edu.escuelaing.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceMongoDB implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User newUser, String id) {
        User user = userRepository.findById(id).orElseThrow(null);
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setLastName(newUser.getLastName());
        if (newUser.getPasswordHash() != null){
            user.setPasswordHash(BCrypt.hashpw(newUser.getPasswordHash(), BCrypt.gensalt()));
        }
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
