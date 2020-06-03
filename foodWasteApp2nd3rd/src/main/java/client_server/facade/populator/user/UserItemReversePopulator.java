package client_server.facade.populator.user;

import client_server.data.user.UserItemData;
import client_server.facade.populator.Populator;
import client_server.model.UserItem;

public class UserItemReversePopulator implements Populator<UserItemData, UserItem> {
    @Override
    public void populate(UserItem userItemData, UserItemData userItem) {
        userItemData.setItemId(userItem.getItemId());
        userItemData.setCalories(userItem.getCalories());
        userItemData.setName(userItem.getName());
        userItemData.setPurchaseDate(userItem.getPurchaseDate());
        userItemData.setExpirationDate(userItem.getExpirationDate());
        userItemData.setQuantity(userItem.getQuantity());
        userItemData.setConsumptionStatus(userItem.isConsumptionStatus());
    }
}
