package client_server.data.user;

import client_server.model.UserRole;

import java.util.List;

public class UserData {

    private String email;
    private String password;
    private UserRole role;
    private String firstName;
    private String lastName;
    private String phoneNumber;


    private List<UserItemData> userItemDataList;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<UserItemData> getUserItemDataList() {
        return userItemDataList;
    }

    public void setUserItemDataList(List<UserItemData> userItemDataList) {
        this.userItemDataList = userItemDataList;
    }
}
