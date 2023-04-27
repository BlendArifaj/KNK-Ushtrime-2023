package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.Pagination;
import models.User;
import models.dto.UserFilter;
import service.UserService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    private Pagination pagination = new Pagination(1, 100); // By default 1 - 100
    @FXML
    private TextField txtFilterUsername;

    @FXML
    private CheckBox checkBoxFilterIsActive;

    @FXML
    private ImageView imageView;

    @FXML
    private void btnFilter(ActionEvent e){
        pagination.setPage(1);
        pagination.setSize(1);
        UserFilter filter = new UserFilter();
        filter.setUsername(this.txtFilterUsername.getText());
        filter.setActive(this.checkBoxFilterIsActive.isSelected());
        List<User> filterUsers = UserService.filterUsers(filter, pagination);
        if(filterUsers == null){
//            Alert
            System.out.println("Error occurred, check filter code!");
        }else{
            this.updateTable(filterUsers);
        }
    }

    private void updateTable(List<User> users){
//        update table
        for(User user: users){
            System.out.println("User: " + user.getUsername());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(getClass().getResourceAsStream("/images/university_of_prishtina.png"));
        this.imageView.setImage(image);
    }
}
