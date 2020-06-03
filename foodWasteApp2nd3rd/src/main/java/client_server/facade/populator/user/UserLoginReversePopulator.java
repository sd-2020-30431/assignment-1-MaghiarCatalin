package client_server.facade.populator.user;

import client_server.data.user.UserLoginData;
import client_server.facade.populator.Populator;
import client_server.model.User;

public class UserLoginReversePopulator implements Populator<UserLoginData, User> {
    @Override
    public void populate(User user, UserLoginData userLoginData) {
        user.setEmail(userLoginData.getEmail());
        user.setPassword(userLoginData.getPassword());
    }
}
