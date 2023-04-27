package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import models.User;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class BaseController implements Initializable {
    @FXML
    private Pagination pagination;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadLangTexts(getLangBundle());
    }
    public ResourceBundle getLangBundle(){
        Locale currentLocale = Locale.getDefault();
        return  ResourceBundle.getBundle("strings", currentLocale);
    }

    public abstract void loadLangTexts(ResourceBundle langBundle);

    private void initializePagination() {
        pagination.setPageFactory(pageIndex -> createPage(pageIndex));
    }

    private Node createPage(int pageIndex) {
        List<User> users = getUsersByPage(pageIndex + 1, 10); // or any other page size you choose
        ObservableList<User> observableUsers = FXCollections.observableArrayList(users);
//        userTable.setItems(observableUsers);
        return null;
    }

    private List<User> getUsersByPage(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        List<User> users = new ArrayList<>(); // userService.getUsersByOffset(offset, pageSize);
        return users;
    }

}