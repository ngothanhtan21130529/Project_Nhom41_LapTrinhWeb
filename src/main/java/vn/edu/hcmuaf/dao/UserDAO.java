package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.model.Role;
import vn.edu.hcmuaf.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public User selectInformation(String username, String password) throws SQLException {

        String sql = "Select username,password,role_name from users join roles on users.roles_id=roles.id where username=? and password=?";
        PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        while (rs.next()) {
            user = new User(rs.getString("username"), rs.getString("password"), new Role(rs.getString("role_name")));
        }
        rs.close();
        preparedStatement.close();
        MySqlConnection.getConnection().close();
        return user;
    }

    public boolean insertUser(User user) throws SQLException {
        String sql = "Insert into users(id,username,password,full_name,email,phone,created_at,birthday)values(?,?,?,?,?,?,CURRENT_TIMESTAMP,?)";

        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        pr.setInt(1, user.getId());
        pr.setString(2, user.getUserName());
        pr.setString(3, user.getPassword());
        pr.setString(4, user.getName());
        pr.setString(5, user.getEmail());
        pr.setString(6, user.getPhone());
        pr.setTimestamp(7, user.getBirthday());
        int execute = pr.executeUpdate();
        if (execute > 0) {
            return true;
        } else {
            return false;
        }


    }

    public boolean updatePassword(String username, String newpassword) throws SQLException {
        String sql = "Update table users set password=? where username=?";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1, newpassword);
        pr.setString(2, username);
        int res = pr.executeUpdate();
        if (res > 0) {
            return true;
        } else {
            return false;
        }

    }

    public String getEmail(String email) throws SQLException {
        String sql = "Select email form users where email=?";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1, email);
        ResultSet rs = pr.executeQuery();
        String emailres = null;
        while (rs.next()) {
            emailres = rs.getString("email");

        }
        return emailres;
    }

    public int getMaxID() throws SQLException {
        String sql = "Select max(id) from users";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pr.executeQuery();
        int maxid = 0;
        while (rs.next()) {
            maxid = rs.getInt("max(id)");
        }
        maxid++;
        return maxid;
    }

    public static void main(String[] args) throws SQLException {

    }

}

