package client_server.facade.converter.user;

import client_server.facade.converter.Converter;
import client_server.facade.populator.Populator;
import client_server.facade.populator.user.UserReversePopulator;
import client_server.data.user.UserData;
import client_server.model.User;

import java.util.List;

public class UserReverseConverter implements Converter<UserData, User> {

    private Populator<UserData, User> userPopulator = new UserReversePopulator();


    @Override
    public User convert(UserData source) {
        User target = new User();
        userPopulator.populate(target, source);
        return target;
    }

    @Override
    public List<User> convertAll(List<UserData> source) {
        return null;
    }
}