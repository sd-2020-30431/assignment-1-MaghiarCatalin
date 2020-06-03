package client_server.dao.user;

import client_server.model.User;
import client_server.model.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    Optional<User> getUserByEmail(String email);

    void update(User updatedUser);

    void delete(String email);

    List<User> getAll();

    void save(User value);

    Optional<User> getByPhoneNumber(String phoneNumber);

    UserRole getCredentials(User user);
}
