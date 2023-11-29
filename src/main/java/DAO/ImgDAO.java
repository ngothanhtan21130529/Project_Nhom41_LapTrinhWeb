package DAO;

import connection.MySqlConnection;
import model.Img;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ImgDAO implements DAOInterface<Img> {

    public static ImgDAO getInstance(){
        return new ImgDAO();
    }

    @Override
    public int insert(Img img) {
        int res=0;
        try {
            Connection con = MySqlConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "insert into imgs (id, img_url, name, create_at, update_at"+
                    "value('"+img.getId()+"', '"+img.getImgUrl()+"', '"+img.getName()+"', '"
                    +img.getCreateAt()+"', '"+img.getUpadatedAt()+"')''";
            res=st.executeUpdate(sql);

            System.out.println("Execute querry success: "+sql);
            System.out.println("There "+res+" line changed!");

            MySqlConnection.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public int update(Img img) {
        int res=0;
        try {
            Connection con = MySqlConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "update imgs"+
                    "set"+
                    " img_url='"+img.getImgUrl()+"'"+
                    ", name='"+img.getName()+"'"+
                    ", created_at='"+img.getCreateAt()+"'"+
                    ", updated_at='"+img.getUpadatedAt()+"'"+
                    " where id='"+img.getId()+"\'";
            res=st.executeUpdate(sql);

            System.out.println("Execute querry success: "+sql);
            System.out.println("There "+res+" line changed!");

            MySqlConnection.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public int delete(Img img) {
        int res=0;
        try {
            Connection con = MySqlConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "delete from imgs"+
                    " where id='"+img.getId()+"'";
            res=st.executeUpdate(sql);

            System.out.println("Execute querry success: "+sql);
            System.out.println("There "+res+" line changed!");

            MySqlConnection.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public Img selectById(Img img) {
        Img res=null;
        try {
            Connection con = MySqlConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from imgs where id='"+img.getId()+"'";
            System.out.println(sql);
            ResultSet rs =st.executeQuery(sql);

            while (rs.next()){
                int id=rs.getInt("id");
                String imgUrl=rs.getString("img_url");
                String name=rs.getString("name");
                Date createdAt=rs.getDate("create_at");
                Date updatedAt=rs.getDate("update_at");

                res=new Img(id, imgUrl, name, createdAt, updatedAt);
            }

            MySqlConnection.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public ArrayList<Img> selectByCondition(String condition) {
        ArrayList<Img> res=new ArrayList<>();
        try {
            Connection con = MySqlConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from imgs where"+condition;
            System.out.println(sql);
            ResultSet rs =st.executeQuery(sql);

            while (rs.next()){
                int id=rs.getInt("id");
                String imgUrl=rs.getString("img_url");
                String name=rs.getString("name");
                Date createdAt=rs.getDate("create_at");
                Date updatedAt=rs.getDate("update_at");

                Img img=new Img(id, imgUrl, name, createdAt, updatedAt);
                res.add(img);
            }

            MySqlConnection.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
