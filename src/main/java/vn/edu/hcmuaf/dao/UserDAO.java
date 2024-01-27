package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.model.Role;
import vn.edu.hcmuaf.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserDAO implements DAOInterface<User> {
    public static UserDAO getInstance() {
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
    public String getEmailforOrder(String email,String username) throws SQLException {
        String sql="Select email from users where username=?";
        PreparedStatement pr=MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1,username);
        ResultSet rs=pr.executeQuery();
        String emailres=null;
        while(rs.next()){
            emailres=rs.getString("email");
        }
        pr.close();
        MySqlConnection.getConnection().close();
        rs.close();
        return emailres;

    }
    public ArrayList<User> getUsernameandPassword() throws SQLException {
        ArrayList<User> listuser = new ArrayList<>();
        String sql = "Select username,password,role_name from users join roles on users.roles_id=roles.id";
        PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        while (rs.next()) {
            user = new User(rs.getString("username"), rs.getString("password"), new Role(rs.getString("role_name")));
            listuser.add(user);
        }
        rs.close();
        preparedStatement.close();
        MySqlConnection.getConnection().close();
        return listuser;
    }

    public boolean insertUser(User user) throws SQLException {
        String sql = "Insert into users(id,username,password,email,roles_id)values(?,?,?,?,2)";

        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        pr.setInt(1, getMaxID() + 1);
        pr.setString(2, user.getUserName());
        pr.setString(3, user.getPassword());
        pr.setString(4, user.getEmail());
        int execute = pr.executeUpdate();
        pr.close();
        MySqlConnection.getConnection().close();
        if (execute > 0) {
            return true;
        } else {
            return false;
        }


    }

    public boolean updatePassword(String username, String newpassword) throws SQLException {
        String sql = "Update  users set password=? where username=?";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1, newpassword);
        pr.setString(2, username);
        int res = pr.executeUpdate();
        pr.close();
        MySqlConnection.getConnection().close();

        if (res > 0) {

            return true;
        } else {
            return false;
        }
    }

    public String getEmailForForgotPassword(String email) throws SQLException {
        String sql = "Select email from users where email=?";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1, email);
        ResultSet rs = pr.executeQuery();
        String emailres = null;
        while (rs.next()) {
            emailres = rs.getString("email");
        }
        pr.close();
        MySqlConnection.getConnection().close();
        rs.close();
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
        pr.close();
        MySqlConnection.getConnection().close();
        rs.close();
        return maxid;
    }

    public String getEmailforLogin(String username) throws SQLException {
        String sql = "Select email from users where username=?";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1, username);
        ResultSet rs = pr.executeQuery();
        String email = null;

        while (rs.next()) {
            email = rs.getString("email");
            if (email != null) {
                break;
            }
        }
        pr.close();
        MySqlConnection.getConnection().close();
        rs.close();

        return email;
    }

    public boolean UpdatePhone(String username, String phone) throws SQLException {
        String sql = "Update users set phone=? where username=?";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        int rs = pr.executeUpdate();
        pr.close();
        MySqlConnection.getConnection().close();
        if (rs > 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> checkedExistsEmail() throws SQLException {
        String sql = "Select email from users";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        ArrayList<String> listemails = new ArrayList<>();
        ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            listemails.add(rs.getString("email"));
        }
        pr.close();
        MySqlConnection.getConnection().close();
        rs.close();
        return listemails;
    }

    public ArrayList<String> checkedExistsUsername() throws SQLException {
        String sql = "Select username from users";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        ArrayList<String> listusernames = new ArrayList<>();
        ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            listusernames.add(rs.getString("username"));
        }
        pr.close();
        MySqlConnection.getConnection().close();
        rs.close();
        return listusernames;
    }

    public String getEmailforRegister(String username) throws SQLException {
        String sql = "Select email from users where username=?";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1, username);
        ResultSet rs = pr.executeQuery();
        String email = null;
        while (rs.next()) {
            email = rs.getString("email");
        }
        pr.close();
        MySqlConnection.getConnection().close();
        rs.close();
        return email;
    }

    public boolean updatePasswordforForgot(String newpassword, String email) throws SQLException {
        String sql = "Update users set password=? where email=?";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1, newpassword);
        pr.setString(2, email);
        int i = pr.executeUpdate();
        pr.close();
        MySqlConnection.getConnection().close();
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }



    public boolean UpdateBirthday(String username, String birthday) throws SQLException, ParseException {
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
        Timestamp timestamp=new Timestamp(date.getTime());
        String sql="Update users set birthday=? where username=?";
        PreparedStatement pr= MySqlConnection.getConnection().prepareStatement(sql);
        pr.setTimestamp(1,timestamp);
        pr.setString(2,username);
        int i=pr.executeUpdate();
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean uploadImg(String username,String avatar) throws SQLException {
        String sql="Update users set avatar=? where username=?";
        PreparedStatement pr=MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1,avatar);
        pr.setString(2,username);
        int i=pr.executeUpdate();
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
    public String getAvatar(String username) throws SQLException {
        String sql="Select avatar from users where username=?";
        PreparedStatement pr=MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1,username);
        ResultSet rs=pr.executeQuery();
        String avatar=null;
        while(rs.next()){
            avatar=rs.getString("avatar");
        }
        pr.close();
        MySqlConnection.getConnection().close();
        rs.close();
        return avatar;
    }
    public int getUserid(String username) throws SQLException {
        String sql="Select id from users where username=?";
        PreparedStatement pr= MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1,username);
        ResultSet rs=pr.executeQuery();
        int userid=0;
        while(rs.next()){
            userid=rs.getInt("id");
        }
        return userid;
    }
    public static void main(String[] args) throws SQLException, ParseException {
        UserDAO userDAO=UserDAO.getInstance();
        System.out.println(userDAO.UpdateBirthday("casterlongan123","1999-12-12"));
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
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
                user.setUpdatedAt(rs.getTimestamp("updated_at"));
                user.setStatus(rs.getString("status"));
                user.setAvatar(rs.getString("avatar"));
                user.setRoleName(rs.getString("role_name"));
                user.setBirthday(rs.getTimestamp("birthday"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}

