package service;

import models.Pagination;
import models.User;
import models.dto.CreateUserDto;
import models.dto.UpdateUserDto;
import models.dto.UserFilter;
import repository.UserRepository;
import repository.interfaces.UserRepositoryInterface;
import service.interfaces.UserServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class UserService implements UserServiceInterface {
//    Repositories
    private UserRepositoryInterface userRepository;

    public UserService() {
//        repositories
        this.userRepository = new UserRepository();
    }

    public User login(String username, String password) throws SQLException {
        User loginUser = UserRepository.getByUsername(username);
        if(loginUser == null){
            return null;
        }
        boolean isPasswordCorrect = PasswordHasher.compareSaltedHash(
                password, loginUser.getSalt(), loginUser.getSaltedPassword()
        );
        if(isPasswordCorrect){
            return loginUser;
        }

        return null;
    }

    public User signUp(String username, String password) throws SQLException{
        String salt = PasswordHasher.generateSalt();
        String saltedHash = PasswordHasher.generateSaltedHash(password, salt);
        CreateUserDto user = new CreateUserDto(username, saltedHash, salt);
        this.userRepository.insert(user);
        return UserRepository.getByUsername(username);
    }

    public static List<User> filterUsers(UserFilter filter, Pagination pagination){
        try{

            return UserRepository.getByFilter(filter, pagination);
        }catch (SQLException e){
            return null;
        }
    }

    public static User updateUser(UpdateUserDto updateUserDto) throws SQLException{
//        logjiken e perditesimit
        User user = UserRepository.update(updateUserDto);
        return user;
    }
}
