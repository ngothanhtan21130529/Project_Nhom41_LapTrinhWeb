package DAO;

import connection.MySqlConnection;
import model.Role;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAOInterface<User> {
    public static UserDAO getInstance() {
        return new UserDAO();
    }

    @Override
    public int insert(User user) throws SQLException {

        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(User user) {
        return 0;
    }

    @Override
    public User selectById(User user) {
        return null;
    }

    @Override
    public ArrayList<User> selectByCondition(String condition) {
        return null;
    }

    public static User  selectInformation(String username,String password) throws SQLException {

        String sql = "Select username,password,role_name from users join roles on users.roles_id=roles.id where username=? and password=?";
        PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        while (rs.next()) {

         user=   new User(rs.getString("username"),rs.getString("password"),new Role(rs.getString("role_name")));

        }
        rs.close();
       return user;
    }


    public static void main(String[] args) throws SQLException {
        System.out.println(selectInformation("tranthaihung2k4","tranthaihung2k4"));
    }

    }

