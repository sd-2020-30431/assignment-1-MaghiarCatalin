import java.sql.*;

public class UserDAO {

    String dbURL = "jdbc:mysql://localhost:3306/foodwaste";
    String username = "root";
    String password = "Analin1317!";

    void insertUser(String fullName, String email){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            String sql = "INSERT INTO user (fullName, email) VALUES (?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, fullName);
            statement.setString(2, email);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    String selectUserById(int userId) {
        String email = null;
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            String sql = "SELECT * FROM user WHERE idUser=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                email = result.getString("email");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if(email == null)
            System.out.println("The user with the " + userId + " id doesn't exist!");
        return email;
    }

    void updateUserById(String fullName, String email, int userId){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            String sql = "UPDATE user SET fullName=?, email=? WHERE idUser=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, fullName);
            statement.setString(2, email);
            statement.setInt(3, userId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    void deleteUser(int userId) {
        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            String sql = "DELETE FROM user WHERE idUser=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, userId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
