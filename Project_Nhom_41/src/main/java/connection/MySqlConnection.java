package connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    public static Connection getConnection() throws SQLException {
        Connection c=null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            String url = "jdbc:mysql://localhost:3306/gemstore";
            String user = "root";
            String password = "";

            c= DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return c;
    }
    public static void closeConnection(Connection c){
        try{
            if(c!=null){
                c.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void printInfo(Connection c){
        try{
            if(c!=null){
                DatabaseMetaData mtdt=c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("Connected to MySQL database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
