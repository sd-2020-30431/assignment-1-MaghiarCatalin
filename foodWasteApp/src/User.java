import java.util.ArrayList;

public class User {
    String fullName;
    String email;
    ArrayList<Item> userItems;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Item> getUserItems() {
        return userItems;
    }

    public void setUserItems(ArrayList<Item> userItems) {
        this.userItems = userItems;
    }
}
