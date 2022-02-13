package co.edu.escuelaing.User.service.impl;

import co.edu.escuelaing.User.data.User;
import co.edu.escuelaing.User.repository.UserRepository;
import co.edu.escuelaing.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User update(User oldUser, String id) {
        User newUser = userRepository.findById(id).orElse(null);
        if (newUser!=null){
            newUser.setName(oldUser.getName());
            newUser.setEmail(oldUser.getEmail());
            newUser.setLastName(oldUser.getLastName());
            return userRepository.save(newUser);
        }
        return null;
    }
}
