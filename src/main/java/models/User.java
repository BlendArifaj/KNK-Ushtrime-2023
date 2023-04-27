package models;

public class User {
    private int id;
    private String username;
    private String saltedPassword;
    private String salt;


    public User(int id, String username, String saltedPassword, String salt) {
        this.id = id;
        this.username = username;
        this.saltedPassword = saltedPassword;
        this.salt = salt;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSaltedPassword() {
        return saltedPassword;
    }

    public void setSaltedPassword(String saltedPassword) {
        this.saltedPassword = saltedPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
