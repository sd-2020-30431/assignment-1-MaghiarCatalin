package client_server.facade.user;

import client_server.data.user.UserData;
import client_server.data.user.UserLoginData;
import client_server.model.UserRole;

import java.util.List;

public interface UserFacade {

    List<UserData> getAll();

    UserRole checkCredentials(UserLoginData userData);

    void delete(String email);

    void insert(UserData userData);

    UserData getByEmail(String email);

    void update(UserData userData1);
}
