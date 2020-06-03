package client_server.facade.converter.user;

import client_server.facade.populator.user.UserLoginReversePopulator;
import client_server.data.user.UserLoginData;
import client_server.facade.converter.Converter;
import client_server.facade.populator.Populator;
import client_server.model.User;

import java.util.List;

public class UserLoginReverseConverter implements Converter<UserLoginData, User> {

    private Populator<UserLoginData, User> userLoginReversePopulator = new UserLoginReversePopulator();

    @Override
    public User convert(UserLoginData source) {
        User target = new User();
        userLoginReversePopulator.populate(target, source);
        return target;
    }

    @Override
    public List<User> convertAll(List<UserLoginData> source) {
        return null;
    }
}
