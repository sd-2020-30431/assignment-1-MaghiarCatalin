package client_server.facade.converter.user;

import client_server.facade.populator.Populator;
import client_server.facade.populator.user.UserItemPopulator;
import client_server.data.user.UserItemData;
import client_server.facade.converter.Converter;
import client_server.model.UserItem;

import java.util.ArrayList;
import java.util.List;

public class UserAddressConverter implements Converter<UserItem, UserItemData> {

    private Populator<UserItem, UserItemData> userItemDataPopulator = new UserItemPopulator();

    @Override
    public UserItemData convert(UserItem source) {
        UserItemData target = new UserItemData();
        userItemDataPopulator.populate(target, source);
        return target;
    }

    @Override
    public List<UserItemData> convertAll(List<UserItem> source) {
        List<UserItemData> target = new ArrayList<>();
        for (UserItem userItem : source) {
            target.add(convert(userItem));
        }
        return target;
    }
}
