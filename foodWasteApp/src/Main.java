import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    static void getConnection(){
        String dbURL = "jdbc:mysql://localhost:3306/foodwaste";
        String username = "root";
        String password = "Analin1317!";

        try {

            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getConnection();
        UserDAO userDAO = new UserDAO();
        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        ItemDAO itemDAO = new ItemDAO();
    }
}
