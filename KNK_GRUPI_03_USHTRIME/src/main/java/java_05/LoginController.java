package java_05;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField pwdPassword;

    @FXML
    private void btnLoginClick(ActionEvent event){
        String username = this.txtUsername.getText();
        String password = this.pwdPassword.getText();
        System.out.printf("Username: %s, Password: %s \n", username, password);
    }
    @FXML
    public void btnClearClick(ActionEvent event) {
        this.txtUsername.setText("");
        this.pwdPassword.setText("");
    }

}
