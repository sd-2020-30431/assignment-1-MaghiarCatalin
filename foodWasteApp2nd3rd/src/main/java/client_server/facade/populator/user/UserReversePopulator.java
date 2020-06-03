package client_server.facade.populator.user;

import client_server.data.user.UserItemData;
import client_server.data.user.UserData;
import client_server.facade.converter.Converter;
import client_server.facade.converter.user.UserAddressReverseConverter;
import client_server.facade.populator.Populator;
import client_server.model.User;
import client_server.model.UserItem;

public class UserReversePopulator implements Populator<UserData, User> {

    private Converter<UserItemData, UserItem> converter = new UserAddressReverseConverter();

    @Override
    public void populate(User user, UserData userData) {
        user.setEmail(userData.getEmail());
        user.setPassword(userData.getPassword());
        user.setRole(userData.getRole());
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        user.setPhoneNumber(userData.getPhoneNumber());
        user.setUserAddressList(null);
    }
}
