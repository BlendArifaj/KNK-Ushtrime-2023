package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Window;
import models.User;
import repository.UserRepository;
import service.UserAuthService;
import service.UserService;
import service.interfaces.UserServiceInterface;

import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginController implements Initializable{
//    Services
    private UserServiceInterface userService;
//    ....


    public LoginController() {
        System.out.println("Controller");
        this.userService = new UserService();
    }

    @FXML
    private TextField txtUsername;
    @FXML
    private Button btnLogin;
    @FXML
    private PasswordField pwdPassword;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Ndrysho tekstin e dizajnit ne baze te gjuhes
        Locale locale = Locale.getDefault();

        ResourceBundle translate = ResourceBundle.getBundle(
                "translations.content", locale
        );
        this.btnLogin.setText(translate.getString("login.button.text"));
    }

    private void translateView(){
//        ResourceBundle translate = this.getResourceBoundle();
        //
//        this.btnLogin.setText(translate.getString("login.button.text"));
    }





    private void translate(){
        Locale currentLocale = Locale.getDefault();
        ResourceBundle translate =
                ResourceBundle.getBundle("translations.content", currentLocale);
        btnLogin.setText(translate.getString("button.login.name"));
        // te tjerat
    }

    private void enClick(ActionEvent e){
        Locale.setDefault(new Locale("en"));
        this.translate();
    }
    @FXML
    private void loginClick(ActionEvent e){
        String username = this.txtUsername.getText();
        String password = this.pwdPassword.getText();
        try{
            User user = this.userService.login(username, password);
            if(user == null){
               System.out.println("Username or password is incorrect!");
               return;
            }
            System.out.println("User is correct!");
        }catch (SQLException sqlException){
            System.out.println("Gabim ne baze te te dhenave!");
        }
    }

    @FXML
    private void cancelClick(ActionEvent e){
        this.txtUsername.setText("");
        this.pwdPassword.setText("");
        Locale.setDefault(new Locale("de", "DE")); // set default locale to German

    }

}
