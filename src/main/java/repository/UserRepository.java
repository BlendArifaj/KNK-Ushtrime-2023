package repository;


import models.Pagination;
import models.dto.CreateUserDto;
import models.dto.UpdateUserDto;
import models.dto.UserFilter;
import repository.interfaces.BaseInterface;
import repository.interfaces.UserRepositoryInterface;
import service.ConnectionUtil;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements UserRepositoryInterface {

    public User insert(CreateUserDto user) throws SQLException {
        String sql = "INSERT INTO users (username, salted_hash, salt) VALUES (?, ?, ?)";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getSaltedPassword());
        statement.setString(3, user.getSalt());
        statement.executeUpdate();

        return UserRepository.getByUsername(user.getUsername());
    }

    public static User get(String columnName, Object value) throws SQLException{
        String sql = "SELECT * FROM users WHERE ?=?";
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1, columnName);
        statement.setObject(2, value);
        ResultSet res = statement.executeQuery();
//        ...
        return null;
    }

    public static User getByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String saltedHash = resultSet.getString("salted_hash");
                String salt = resultSet.getString("salt");
                return new User(id, username, saltedHash, salt);
            } else {
                return null;
            }
        }
    }

    public static List<User> getByFilter(UserFilter filters, Pagination pagination) throws SQLException{
        List<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM users WHERE 1=1";
        ArrayList<Object> params = new ArrayList<Object>();

        sql += filters.getFilterQuery();
        params.addAll(filters.getFilterParams());
        sql += pagination.getSQLQuery();
        params.addAll(pagination.getSQLParams());
        /// other filter options

        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        for(int i = 0; i < params.size(); i++){
            preparedStatement.setObject(i+1, params.get(i));
        }
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            users.add(
              new User(
                      resultSet.getInt(1),
                      resultSet.getString(2),
                      resultSet.getString(3),
                      resultSet.getString(4)
              )
            );
        }

        return users;
    }

    public static User update(UpdateUserDto user) throws SQLException{
        String sql = "UPDATE user SET salted_password = ? WHERE id = ?";
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setObject(1, user.getSaltedPassword());
        preparedStatement.setObject(2, user.getId());
        preparedStatement.executeUpdate();

        return UserRepository.get("id", user.getId());
    }
}
