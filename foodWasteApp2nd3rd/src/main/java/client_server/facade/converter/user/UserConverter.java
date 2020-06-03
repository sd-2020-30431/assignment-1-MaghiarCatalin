package client_server.facade.converter.user;

import client_server.facade.converter.Converter;
import client_server.facade.populator.Populator;
import client_server.facade.populator.user.UserPopulator;
import client_server.data.user.UserData;
import client_server.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserConverter implements Converter<User, UserData> {

    private Populator<User, UserData> userDataPopulator = new UserPopulator();


    @Override
    public UserData convert(User source) {
        UserData target = new UserData();
        userDataPopulator.populate(target, source);
        return target;
    }

    @Override
    public List<UserData> convertAll(List<User> source) {
        List<UserData> target = new ArrayList<UserData>();
        for (User user : source) {
            target.add(convert(user));
        }
        return target;
    }
}
