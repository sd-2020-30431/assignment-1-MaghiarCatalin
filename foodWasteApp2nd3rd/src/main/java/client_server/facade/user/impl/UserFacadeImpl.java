package client_server.facade.user.impl;

import client_server.facade.converter.Converter;
import client_server.facade.converter.user.UserConverter;
import client_server.facade.converter.user.UserLoginReverseConverter;
import client_server.facade.converter.user.UserReverseConverter;
import client_server.facade.user.UserFacade;
import client_server.service.user.UserService;
import client_server.data.user.UserData;
import client_server.data.user.UserLoginData;
import client_server.model.User;
import client_server.model.UserRole;
import client_server.service.user.impl.UserServiceImpl;

import java.util.List;
import java.util.Optional;

public class UserFacadeImpl implements UserFacade {

    private UserService userService = new UserServiceImpl();
    private Converter<User, UserData> converter = new UserConverter();
    private Converter<UserLoginData, User> userLoginReverseConveter = new UserLoginReverseConverter();
    private Converter<UserData, User> userReverseConverter = new UserReverseConverter();

    @Override
    public List<UserData> getAll() {
        List<User> users = userService.getAll();
        return converter.convertAll(users);
    }

    @Override
    public UserRole checkCredentials(UserLoginData userData) {
        User user = userLoginReverseConveter.convert(userData);

        return userService.getCredentials(user);
    }

    @Override
    public void delete(String email) {
        userService.delete(email);
    }

    @Override
    public void insert(UserData userData) {
        User user = userReverseConverter.convert(userData);
        userService.insert(user);
    }

    @Override
    public UserData getByEmail(String email) {
        Optional<User> user = userService.getByEmail(email);
        User user1 = user.get();
        return converter.convert(user1);
    }

    @Override
    public void update(UserData userData1) {
        User user = userReverseConverter.convert(userData1);
        userService.update(user);
    }
}
