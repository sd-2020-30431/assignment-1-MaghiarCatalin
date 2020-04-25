import java.sql.*;
import java.util.ArrayList;

public class ShoppingCartDAO {
    String dbURL = "jdbc:mysql://localhost:3306/foodwaste";
    String username = "root";
    String password = "Analin1317!";

    void insertItemCart(int userId, int itemId){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            String sql = "INSERT INTO shoppingcart (userID, itemID) VALUES (?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, itemId);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new item for the user's shopping cart was inserted successfully!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    void deleteItemFromUser(int userId, int itemId){
        int arrayPosition = 0;
        ArrayList<Integer> idShoppingCart = new ArrayList<>();
        ArrayList<Integer> itemIDsList = selectUserListItemsById(userId, idShoppingCart);

        System.out.println(idShoppingCart);
        System.out.println(itemIDsList);

        for(int i = 0; i < itemIDsList.size(); i++){
            if(itemIDsList.get(i) == itemId){
                arrayPosition = idShoppingCart.get(i);
                break;
            }
        }

        System.out.println(arrayPosition);

        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            String sql = "DELETE FROM shoppingcart WHERE idshoppingcart=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, arrayPosition);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An item for the user's shopping cart was deleted successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

     ArrayList<Integer> selectUserListItemsById(int userId, ArrayList<Integer> idShoppingCart) {
        ArrayList<Integer> itemIDsList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            String sql = "SELECT * FROM shoppingcart WHERE userID=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                itemIDsList.add(result.getInt("itemID"));
                idShoppingCart.add(result.getInt("idshoppingcart"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return itemIDsList;
    }

    void updateUserListItemsById(int userId, int itemId, Array itemListInts, int idShoppingCart){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            String sql = "UPDATE shoppingcart SET userID=?, itemID=?, itemsList=? WHERE idshoppingcart=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, itemId);
            statement.setArray(3, itemListInts);
            statement.setInt(4, idShoppingCart);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing item for the user's shopping cart was updated successfully!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
