package co.edu.escuelaing.User.data;

import co.edu.escuelaing.User.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document
public class User {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private String lastName;
    private String createdAt;
    private String passwordHash;
    private List<RoleEnum> roles;

    public User(UserDto userDto) {
        this.id = UUID.randomUUID().toString();
        this.createdAt = String.valueOf(new Date());
        this.passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }
}
