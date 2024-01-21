package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ImageDAO implements DAOInterface<Image> {
    public static ImageDAO getInstance(){
        return new ImageDAO();
    }

    @Override
    public int insert(Image i){
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "insert into images (id, img_url, image_name)"+
                    "values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, i.getId());
            ps.setString(2, i.getImgURL());
            ps.setString(3, i.getImageName());
            int res=ps.executeUpdate();
            ps.close();
            con.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Image i) {
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "update images i set i.img_url=?, i.image_name=? where i.id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, i.getImgURL());
            ps.setString(2, i.getImageName());
            ps.setInt(3, i.getId());
            int res=ps.executeUpdate();
            ps.close();
            con.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Image i) {
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "delete from images where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, i.getId());
            int res=ps.executeUpdate();
            ps.close();
            con.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Image selectById(Image image) {
        return null;
    }

    @Override
    public ArrayList selectByCondition(String condition) {
        return null;
    }
    public int getMaxID(){
        int max=0;
        try {
            String sql = "SELECT MAX(i.id) FROM images i;";
            Connection con = MySqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                max=rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return max;
    }
    public ArrayList<Image> getListImageFull() {
        ArrayList<Image> imageArrayList = new ArrayList<>();
        try {
            String query = "SELECT i.id, i.img_url, i.image_name from images i";
            Connection con = MySqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Image image=new Image(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)
                );
                imageArrayList.add(image);
            }
            con.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imageArrayList;
    }

}
