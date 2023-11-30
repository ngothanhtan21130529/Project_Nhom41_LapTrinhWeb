package DAO;

import connection.MySqlConnection;
import model.Image;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImageDAO implements DAOInterface<Image> {

    public static ImageDAO getInstance() {
        return new ImageDAO();
    }

    @Override
    public int insert(Image img) {
        int res = 0;
        try {
            Connection con = MySqlConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "insert into images (id, img_url, product_detail_id" +
                    "value('" + img.getId() + "', '" + img.getImgURL() + "', '"
                    + img.getProductDetailID() + "')''";
            res = st.executeUpdate(sql);

            System.out.println("Execute querry success: " + sql);
            System.out.println("There " + res + " line changed!");

            MySqlConnection.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public int update(Image img) {
        int res = 0;
        try {
            Connection con = MySqlConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "update imgs" +
                    "set" +
                    " img_url='" + img.getImgURL() + "'" +
                    ", product_detail_id='" + img.getProductDetailID() + "'" +
                    " where id='" + img.getId() + "\'";
            res = st.executeUpdate(sql);

            System.out.println("Execute querry success: " + sql);
            System.out.println("There " + res + " line changed!");

            MySqlConnection.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public int delete(Image img) {
        int res = 0;
        try {
            Connection con = MySqlConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "delete from images" +
                    " where id='" + img.getId() + "'";
            res = st.executeUpdate(sql);

            System.out.println("Execute querry success: " + sql);
            System.out.println("There " + res + " line changed!");

            MySqlConnection.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public Image selectById(Image img) {
        Image res = null;
        try {
            Connection con = MySqlConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from images where id='" + img.getId() + "'";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                int product_detail_id = rs.getInt("product_detail_id");
                String imgURL = rs.getString("img_url");

                res = new Image(id, imgURL, product_detail_id);
            }

            MySqlConnection.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public ArrayList<Image> selectByCondition(String condition) {
        ArrayList<Image> res = new ArrayList<>();
        try {
            Connection con = MySqlConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from images where" + condition;
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String imgURL = rs.getString("img_url");
                int productDetailID = rs.getInt("product_detail_id");

                Image img = new Image(id, imgURL, productDetailID);
                res.add(img);
            }

            MySqlConnection.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
