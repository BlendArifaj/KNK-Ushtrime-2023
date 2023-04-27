package java_06;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, 2);
        ResultSet results = statement.executeQuery();
        while(results.next()){
            System.out.println(results.getString(2));
        }



//        String sql = "UPDATE users set firstname = ?, lastname=? WHERE id = ?";
//        Connection connection = ConnectionUtil.getConnection();
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, "Blend");
//        statement.setString(2, "Blend");
//        statement.setInt(3, 1);
//        statement.executeUpdate();

//        User newUser = new User(-1, "test1", "test1", 25);
//        UserRepository.insert(newUser);
//
//          User user = UserRepository.getById(4);
//          user.setAge(27);
//          user.setFirstName("Student2");
//          user.save();

//        if(results.next()){
//            System.out.println(results.getString(2));
//        }
    }
}
