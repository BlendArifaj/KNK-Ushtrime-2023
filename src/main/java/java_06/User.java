package java_06;

import java.sql.SQLException;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    // Constructors
    public User() {}

    public User(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void save() throws SQLException {
        UserRepository.update(this);
    }

    public void setAge(int age) {
        this.age = age;
    }
}
