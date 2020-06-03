package client_server.facade.populator.user;

import client_server.data.user.UserItemData;
import client_server.facade.populator.Populator;
import client_server.model.UserItem;

public class UserItemPopulator implements Populator<UserItem, UserItemData> {
    @Override
    public void populate(UserItemData userItemData, UserItem userItem) {
        userItem.setItemId(userItemData.getItemId());
        userItem.setCalories(userItemData.getCalories());
        userItem.setName(userItemData.getName());
        userItem.setPurchaseDate(userItemData.getPurchaseDate());
        userItem.setExpirationDate(userItemData.getExpirationDate());
        userItem.setQuantity(userItemData.getQuantity());
        userItem.setConsumptionStatus(userItemData.isConsumptionStatus());
    }
}
