import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Controller {

    @FXML
    TextField fullName;

    @FXML
    TextField  email;

    public void loginOnClick(){
        String fullNameField = fullName.getText();
        String emailField = email.getText();
    }

}
