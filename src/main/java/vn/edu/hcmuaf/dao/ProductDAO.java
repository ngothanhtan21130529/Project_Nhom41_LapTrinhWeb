package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.database.Queries;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.model.ProductDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements DAOInterface<Product> {
    public static ProductDAO getInstance() throws SQLException {
        return new ProductDAO();
    }

    @Override
    public int insert(Product product) throws SQLException {
        return 0;
    }

    @Override
    public int update(Product product) {
        return 0;
    }

    @Override
    public int delete(Product product) {
        return 0;
    }

    @Override
    public Product selectById(Product product) {
        return null;
    }

    @Override
    public ArrayList<Product> selectByCondition(String condition) {
        return null;
    }

    private Connection connection;

    public ProductDAO() throws SQLException {
        this.connection = MySqlConnection.getConnection();
    }

    public ResultSet getListProductWithImage(){
        try {
            PreparedStatement ps = connection.prepareStatement(Queries.GET_LIST_PRODUCTS_WITH_IMAGE);
            return ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getInventories(){
        try {
            PreparedStatement ps = connection.prepareStatement(Queries.GET_INVENTORIES);
            return ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getListJewlryWithImage(){
        try {
            PreparedStatement ps =connection.prepareStatement(Queries.GET_lIST_JEWELRY);
            return ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getListProductImage(){
        try {
            PreparedStatement ps = connection.prepareStatement(Queries.GET_LIST_PRODUCT_IMAGE_BY_ID);
            return ps.executeQuery();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ResultSet getProductByID(int productID) {
        try {
            PreparedStatement ps = connection.prepareStatement(Queries.GET_PRODUCT_BY_ID);
            ps.setInt(1, productID);
            return ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getProductImagesByID(int productID){
        try {
            PreparedStatement ps =connection.prepareStatement(Queries.GET_LIST_PRODUCT_IMAGE_BY_ID );
            ps.setInt(1, productID);
            return ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getProductCategoryNameByID(int productID){
        try {
            PreparedStatement ps = connection.prepareStatement(Queries.GET_PRODUCT_CATEGORY_NAME_BY_ID);
            ps.setInt(1, productID);
            return ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ResultSet getListProductWithImageByCategoryID(int categoryId) {
        try {
            PreparedStatement ps = connection.prepareStatement(Queries.GET_LIST_PRODUCT_WITH_IMAGE_BY_CATEGORY_ID);
            return ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getListProductNotJewerly() {
        try {
            PreparedStatement ps = connection.prepareStatement(Queries.GETLISIST_PRODUCT_NOT_JEWELRY);
            return ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
