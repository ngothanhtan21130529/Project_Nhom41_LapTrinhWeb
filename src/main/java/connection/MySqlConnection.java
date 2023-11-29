package connection;

import java.sql.Connection;
<<<<<<< HEAD:Project_Nhom_41/src/main/java/connection/MySqlConnection.java
import java.sql.DatabaseMetaData;
=======
>>>>>>> a42ba191a9b23e04b6c495494e567103761d939e:src/main/java/connection/MySqlConnection.java
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    public static Connection getConnection() throws SQLException {
<<<<<<< HEAD:Project_Nhom_41/src/main/java/connection/MySqlConnection.java
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
=======
        String url = "jdbc:mysql://localhost:3306/gemstore";
        String user = "root";
        String password = "";

        return DriverManager.getConnection(url, user, password);
    }

>>>>>>> a42ba191a9b23e04b6c495494e567103761d939e:src/main/java/connection/MySqlConnection.java
    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("Connected to MySQL database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
<<<<<<< HEAD:Project_Nhom_41/src/main/java/connection/MySqlConnection.java
}
=======
}
>>>>>>> a42ba191a9b23e04b6c495494e567103761d939e:src/main/java/connection/MySqlConnection.java
