package models.dto;

public class CreateUserDto {
    private String username;
    private String saltedPassword;
    private String salt;

    public CreateUserDto(String username, String saltedPassword, String salt) {
        this.username = username;
        this.saltedPassword = saltedPassword;
        this.salt = salt;
    }

    public String getUsername() {
        return username;
    }

    public String getSaltedPassword() {
        return saltedPassword;
    }

    public String getSalt() {
        return salt;
    }
}
