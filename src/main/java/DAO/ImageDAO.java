package DAO;

import java.sql.*;

public class ImageDAO {
    public ImageDAO() {
    }
    public static Connection connect() throws SQLException{
        Connection connection=null;
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String url = "jdbc:mysql://localhost:3306/gemstore";
        connection = DriverManager.getConnection(url,"root","");
        return connection;
    }
}
