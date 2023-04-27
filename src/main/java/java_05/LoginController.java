package java_05;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField pwdPassword;

    @FXML
    private void loginClick(ActionEvent e){
        String username = this.txtUsername.getText();
        String password = this.pwdPassword.getText();

        System.out.printf("Username: %s, Password: %s", username, password);
    }

    @FXML
    private void cancelClick(ActionEvent e){
        this.txtUsername.setText("");
        this.pwdPassword.setText("");
    }
}
