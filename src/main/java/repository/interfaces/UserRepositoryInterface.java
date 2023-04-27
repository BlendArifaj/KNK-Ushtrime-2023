package repository.interfaces;

import models.User;
import models.dto.CreateUserDto;

import java.sql.SQLException;

public interface UserRepositoryInterface {
    public User insert(CreateUserDto user) throws SQLException;
}
