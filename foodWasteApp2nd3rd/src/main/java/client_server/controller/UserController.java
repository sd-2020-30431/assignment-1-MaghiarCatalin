package client_server.controller;

import client_server.data.user.UserItemData;
import client_server.data.user.UserData;
import client_server.data.user.UserLoginData;
import client_server.facade.user.UserFacade;
import client_server.facade.user.impl.UserFacadeImpl;
import client_server.model.UserRole;

import java.util.List;
public class UserController {
    private UserFacade userFacade = new UserFacadeImpl();

    public List<UserData> listAllUsers() {
        List<UserData> userDataList = userFacade.getAll();
        for (UserData userdata : userDataList) {
            System.out.println(userdata.getFirstName());
            for (UserItemData userItemData : userdata.getUserItemDataList()) {
                System.out.println(userItemData.getName());

            }

        }
        return userDataList;
    }

    public UserRole checkCredentials(String username, String password) {
        UserLoginData userLoginData = new UserLoginData();
        userLoginData.setEmail(username);
        userLoginData.setPassword(password);

        System.out.println(userFacade.checkCredentials(userLoginData));

        return userFacade.checkCredentials(userLoginData);
    }

    public String getInfo(UserData userData) {
        StringBuilder result = new StringBuilder();
        result.append("Name: " + userData.getFirstName() + " " + userData.getLastName());
        result.append("\nE-mail:" + userData.getEmail());
        result.append("\nPhone Number: " + userData.getPhoneNumber());
        result.append("\nNumber of items: " + userData.getUserItemDataList().size());
        if (userData.getUserItemDataList().size() != 0) {
            result.append("\nBuildings:");
            for (UserItemData userItemData : userData.getUserItemDataList()) {
                result.append("\n\tItemId:\t" + userItemData.getItemId());
                result.append("\n\tCalories:\t" + userItemData.getCalories());
                result.append("\n\tQuantity:\t" + userItemData.getQuantity());
                result.append("\n\tExpirationDate:\t" + userItemData.getExpirationDate());
                result.append("\n\tPurchaseDate:\t" + userItemData.getPurchaseDate());
                result.append("\n\tConsumptionStatus:\t" + userItemData.isConsumptionStatus());
                result.append("\n***************************************************************");
            }
        }
        return result.toString();
    }

    public String deleteUser(String email) {
        try {
            userFacade.delete(email);
        } catch (Exception e) {
            return "Error: Cannot delete the user!";
        }
        return "Successful deleted!";
    }

    public void insert(UserData userData) {
        userFacade.insert(userData);
    }

    public UserData getByEmail(String email) {
        return userFacade.getByEmail(email);
    }

    public void update(UserData userData1) {
        userFacade.update(userData1);
    }
}
