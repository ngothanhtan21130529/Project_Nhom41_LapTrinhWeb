package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.model.Role;
import vn.edu.hcmuaf.model.User;

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

    public  User selectInformation(String username, String password) throws SQLException {

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

    public  boolean insertUser(User user) throws SQLException {
        String sql = "insert into users(username,password) values(?,?)";
        PreparedStatement pr=MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1, user.getUserName());
        pr.setString(2, user.getPassword());
        int res=pr.executeUpdate();
        if(res>0){
            return true;
        }else{
            return false;
        }

    }
    public String getEmail(String email) throws SQLException {
        String sql="Select email from users where email=?";
        PreparedStatement pr=MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1,email);
        ResultSet rs=pr.executeQuery();
        String res=null;
        while(rs.next()){
             res=rs.getString("email");
        }
        return res;
    }

    public static void main(String[] args) throws SQLException {

    }

}

