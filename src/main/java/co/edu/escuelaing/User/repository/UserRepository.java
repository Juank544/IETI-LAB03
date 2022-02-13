package co.edu.escuelaing.User.repository;

import co.edu.escuelaing.User.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
