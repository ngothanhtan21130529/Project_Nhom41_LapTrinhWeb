package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.model.Role;
import vn.edu.hcmuaf.model.User;

import java.sql.Connection;
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
        return  0;
    }

    @Override
    public int update(User user) {
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "update users u set " +
                    "c.full_name=?, c.avatar=?, c.roles_id=? " +
                    "c.updated_at=CURRENT_TIMESTAMP, u.status=? " +
                    "where u.id=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getAvatar());
            ps.setInt(3, user.getRole().getId());
            int res = ps.executeUpdate();
            ps.close();
            con.close();
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    public  ArrayList<User> getListUserFull(){
        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = "SELECT u.id, u.username, u.full_name, u.email, \n" +
                    "u.phone, u.created_at, u.updated_at, u.status, \n" +
                    "u.avatar, r.role_name, u.birthday \n" +
                    "from users u join roles r on u.roles_id=r.id;";
            Connection con = MySqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            /*
            * User(int id, String userName, String name, String email,
            *       String phone, Timestamp createdAt, Timestamp updatedAt,
            *       String status, String avatar, String roleName, Timestamp birthday)
            * */
            while (rs.next()) {
                User user=new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at"),
                        rs.getString("status"),
                        rs.getString("avatar"),
                        rs.getString("role_name"),
                        rs.getTimestamp("birthday")
                );
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
