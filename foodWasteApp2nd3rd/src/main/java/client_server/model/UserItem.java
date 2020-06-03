package client_server.model;

import javax.persistence.*;

@Entity
@Table(name = "user_items")
public class UserItem {

    private Integer itemId;
    private User user;
    private String name;
    private String expirationDate;
    private String purchaseDate;
    private Integer calories;
    private Integer quantity;
    private boolean consumptionStatus;

    public UserItem(Integer itemId, Integer calories, Integer quantity, String name, String expirationDate, String purchaseDate, boolean consumptionStatus) {
        this.itemId = itemId;
        this.calories = calories;
        this.quantity = quantity;
        this.name = name;
        this.expirationDate = expirationDate;
        this.purchaseDate = purchaseDate;
        this.consumptionStatus = consumptionStatus;
    }

    public UserItem() {
    }

    @ManyToOne
    @JoinColumn(name = "email", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "itemName", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "expirationDate", nullable = false)
    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Column(name = "purchaseDate", nullable = false)
    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Column(name = "itemId", nullable = false)
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Column(name = "calories")
    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    @Id
    @Column(name = "quantity", unique = true, nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Column(name = "consumptionStatus", nullable = false)
    public boolean isConsumptionStatus() { return consumptionStatus; }

    public void setConsumptionStatus(boolean consumptionStatus) {
        this.consumptionStatus = consumptionStatus;
    }
}