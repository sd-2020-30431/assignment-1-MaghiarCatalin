package client_server.facade.populator.user;

import client_server.data.user.UserItemData;
import client_server.data.user.UserData;
import client_server.facade.converter.Converter;
import client_server.facade.converter.user.UserAddressConverter;
import client_server.facade.populator.Populator;
import client_server.model.User;
import client_server.model.UserItem;

public class UserPopulator implements Populator<User, UserData> {

    private Converter<UserItem, UserItemData> converter = new UserAddressConverter();

    @Override
    public void populate(UserData userData, User user) {
        userData.setEmail(user.getEmail());
        userData.setPassword(user.getPassword());
        userData.setRole(user.getRole());
        userData.setFirstName(user.getFirstName());
        userData.setLastName(user.getLastName());
        userData.setPhoneNumber(user.getPhoneNumber());
        userData.setUserItemDataList(converter.convertAll(user.getUserAddressList()));
    }
}