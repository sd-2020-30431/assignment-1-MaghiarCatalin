package client_server.data.user;

import client_server.model.User;

import javax.persistence.criteria.CriteriaBuilder;

public class UserItemData {

    private Integer itemId;
    private User user;
    private String name;
    private String expirationDate;
    private String purchaseDate;
    private Integer calories;
    private Integer quantity;
    private boolean consumptionStatus;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer addressId) {
        this.itemId = itemId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isConsumptionStatus() {
        return consumptionStatus;
    }

    public void setConsumptionStatus(boolean consumptionStatus) {
        this.consumptionStatus = consumptionStatus;
    }
}
