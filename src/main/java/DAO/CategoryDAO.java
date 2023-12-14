package DAO;

import connection.MySqlConnection;
import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO implements DAOInterface {

    @Override
    public int insert(Object o) throws SQLException {
        return 0;
    }

    @Override
    public int update(Object o) {
        return 0;
    }

    @Override
    public int delete(Object o) {
        return 0;
    }

    @Override
    public Object selectById(Object o) {
        return null;
    }

    @Override
    public ArrayList selectByCondition(String condition) {
        return null;
    }

    public static ArrayList<Category> getListCategory(){
        ArrayList<Category> categories = new ArrayList<>();
        try{
            Connection con = MySqlConnection.getConnection();
            String sql = "SELECT c.id, c.category_name, i.img_url FROM categories c " +
                    "JOIN images i ON c.img_id = i.id";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql );

            while (rs.next()){
                int id = rs.getInt("id");
                String categoryName = rs.getString("category_name");
                String imgURL = rs.getString("img_url");

                Category category = new Category(id, categoryName, imgURL);
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    public int count(String txtSearch){
        try {
            String query="select count(categories.id) from categories where categories.category_name like ?";
            Connection con=MySqlConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,"%"+txtSearch+"%");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Category> search(String txtSearch, int index, int size){
        ArrayList<Category>categories=new ArrayList<>();
        try {
            String query="with res as (select row_number() over (order by c.id asc) " +
                    "as r, c.id, c.category_name from categories c " +
                    "where c.category_name like ?) " +
                    "select * from res where r between (?*?)-(?-1) and (?*?)";
            Connection con=MySqlConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,"%"+txtSearch+"%");
            ps.setInt(2,index);
            ps.setInt(3,size);
            ps.setInt(4,size);
            ps.setInt(5, index);
            ps.setInt(6, size);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
//                Category category=new Category(rs.getString(2),
////                        rs.getString(3)
////                );
////                categories.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    }
}
