package client_server.service.user;

import client_server.model.User;
import client_server.model.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAll();

    UserRole getCredentials(User user);

    void delete(String ean);

    void insert(User user);

    Optional<User> getByEmail(String email);

    void update(User user);
}
