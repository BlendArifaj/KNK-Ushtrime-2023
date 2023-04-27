package models.dto;

import java.util.List;

public class UserFilter {
//    Fushat te cilat do te behet filtrimi
    private String username;
    private boolean isActive;
//    ...

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getUsernameQuery(){
        return " AND username LIKE %?% ";
    }

    public String getIsActiveQuery(){
        return " AND is_active ";
    }

//    TODO: implement in this way
//    TODO: create interface BaseFilterInterface which contains those two methods
//    Every Filter class should implement BaseFilterInterface
    public String getFilterQuery(){
        return null;
    }

    public List<Object> getFilterParams(){
        return null;
    }
}
