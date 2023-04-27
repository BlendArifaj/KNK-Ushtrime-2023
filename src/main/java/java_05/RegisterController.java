package java_05;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.User;
import service.UserAuthService;

import java.sql.SQLException;

public class RegisterController {
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField age;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField pwdPassword;

    @FXML
    private void registerClick(ActionEvent e){
        String firstName = this.txtFirstName.getText();
        String lastName = this.txtLastName.getText();
        int age = Integer.parseInt(this.age.getText());
        String username = this.txtUsername.getText();
        String password = this.pwdPassword.getText();

        try{
            User user = UserAuthService.register(
                    firstName, lastName, age, username, password
            );
        }catch (SQLException sqlException){

        }

        System.out.printf("Username: %s, Password: %s", username, password);
    }

    @FXML
    private void cancelClick(ActionEvent e){
        this.txtUsername.setText("");
        this.pwdPassword.setText("");
    }
}
