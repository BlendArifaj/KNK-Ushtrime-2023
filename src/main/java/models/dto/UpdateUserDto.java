package models.dto;

public class UpdateUserDto {
    private int id;
    private String saltedPassword;

    public UpdateUserDto(int id, String saltedPassword) {
        this.id = id;
        this.saltedPassword = saltedPassword;
    }

    public int getId() {
        return id;
    }

    public String getSaltedPassword() {
        return saltedPassword;
    }
}
