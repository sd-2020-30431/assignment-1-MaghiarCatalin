import java.sql.*;

public class ItemDAO {
    String dbURL = "jdbc:mysql://localhost:3306/foodwaste";
    String username = "root";
    String password = "Analin1317!";

    void insertItem(String name, int quantity, int calorieValue, String purchaseDate, String expirationDate,
                    String consumptionDate) {
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            String sql = "INSERT INTO item (name, quantity, calorieValue, purchaseDate, expirationDate, " +
                    " consumptionDate) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, quantity);
            statement.setInt(3, calorieValue);
            statement.setString(4, purchaseDate);
            statement.setString(5, expirationDate);
            statement.setString(6, consumptionDate);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new item was inserted successfully!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    Item selectItemById(int itemId) {
        Item selectedItem = new Item();
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            String sql = "SELECT * FROM item WHERE idItem=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, itemId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                selectedItem.name = result.getString("name");
                selectedItem.quantity = result.getInt("quantity");
                selectedItem.calorieValue = result.getInt("calorieValue");
                selectedItem.purchaseDate = result.getString("purchaseDate");
                selectedItem.expirationDate = result.getString("expirationDate");
                selectedItem.consumptionDate = result.getString("consumptionDate");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return selectedItem;
    }

    void updateItemById(String name, int quantity, int calorieValue, String purchaseDate, String expirationDate,
                        String consumptionDate, int itemId){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            String sql = "UPDATE item SET name=?, quantity=?, calorieValue=?, purchaseDate=?, expirationDate=?," +
                    " consumptionDate=? WHERE idItem=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, quantity);
            statement.setInt(3, calorieValue);
            statement.setString(4, purchaseDate);
            statement.setString(5, expirationDate);
            statement.setString(6, consumptionDate);
            statement.setInt(7, itemId);


            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing item was updated successfully!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    void deleteItemById(int itemId) {
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            String sql = "DELETE FROM item WHERE idItem=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, itemId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An item was deleted successfully!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
