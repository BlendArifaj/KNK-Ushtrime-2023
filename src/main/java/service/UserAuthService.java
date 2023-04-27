package service;

import models.User;
import models.dto.CreateUserDto;
import repository.UserRepository;

import java.sql.SQLException;

public class UserAuthService {
    public static User login(String username, String password) throws SQLException {
        User user = UserRepository.getByUsername(username);
        if(user == null){
            return null;
        }
        if(PasswordHasher.compareSaltedHash(password, user.getSalt(), user.getSaltedPassword())){
            return user;
        }
        return null;
    }

    public static User register(
            String firstName, String lastName, int age, String username, String password
    ) throws SQLException{
        //Create user
        // username, salt, saltedPasswordHash
        User user = UserRepository.getByUsername(username);
        if(user != null){
            //throw new ResourceAlreadyExistsError()
            return null;
        }
        String salt = PasswordHasher.generateSalt();
        String saltedPasswordHash = PasswordHasher.generateSaltedHash(password, salt);
//        user = UserRepository.insert(new CreateUserDto(username, saltedPasswordHash, salt));

        // Create user profile
        // user_id
        // firstname
        // lastname
        // age
//        UserProfileRepository.insert(
//                new UserProfile(0, user.getId(), firstName, lastName, age)
//        );
        return user;
    }

}
