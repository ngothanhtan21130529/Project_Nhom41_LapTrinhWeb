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
    public static UserDAO getInstance(){
        return new UserDAO();
    }
    @Override
    public int insert(User user){

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
    public List<User> selectInformation() throws SQLException {
        List<User> userlist=new ArrayList<>();
        String sql="Select username,password,roles.name from users join roles on users.role_id=roles.id where username=? and password=?";
        PreparedStatement preparedStatement= MySqlConnection.getConnection().prepareStatement(sql);
        ResultSet rs=preparedStatement.executeQuery(sql);
        while(rs.next()){
            User user=new User(rs.getString(1),rs.getString(2),new Role(rs.getString(3)));
            userlist.add(user);

        }
        return  userlist;
    }
}
