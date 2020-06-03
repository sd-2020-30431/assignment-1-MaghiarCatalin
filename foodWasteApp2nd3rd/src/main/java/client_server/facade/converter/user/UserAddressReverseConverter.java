package client_server.facade.converter.user;

import client_server.facade.populator.user.UserItemReversePopulator;
import client_server.data.user.UserItemData;
import client_server.facade.converter.Converter;
import client_server.facade.populator.Populator;
import client_server.model.UserItem;

import java.util.ArrayList;
import java.util.List;

public class UserAddressReverseConverter implements Converter<UserItemData, UserItem> {

    private Populator<UserItemData, UserItem> userItemDataPopulator = new UserItemReversePopulator();

    @Override
    public UserItem convert(UserItemData source) {
        UserItem target = new UserItem();
        userItemDataPopulator.populate(target, source);
        return target;
    }

    @Override
    public List<UserItem> convertAll(List<UserItemData> source) {
        List<UserItem> target = new ArrayList<>();
        for (UserItemData userItem : source) {
            target.add(convert(userItem));
        }
        return target;
    }
}
