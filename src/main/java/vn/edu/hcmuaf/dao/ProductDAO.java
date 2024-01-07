package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.database.Queries;
import vn.edu.hcmuaf.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO implements DAOInterface<Product> {
    public static ProductDAO getInstance() throws SQLException {
        return new ProductDAO();
    }

    @Override
    public int insert(Product product){
        String sql = "insert into products (id, category_id, product_name, " +
                "price, status, thumbnail_id, sale, hot, description, " +
                "created_at, updated_at, deleted_at, color, weight, opacity, " +
                "size, cutting_grinding_type, material) " +
                "values(?,?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP,null,null,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MySqlConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, product.getId());
            ps.setInt(2, product.getCategoryID());
            ps.setString(3, product.getProductName());
            ps.setInt(4, product.getPrice());
            ps.setString(5, product.getStatus());
            ps.setInt(6, product.getThumbnailID());
            ps.setInt(7, product.getSale());
            ps.setBoolean(8, product.isHot());
            ps.setString(9, product.getDescription());
            ps.setString(10, product.getStoneColor());
            ps.setString(11, product.getWeight());
            ps.setString(12, product.getOpacity());
            ps.setString(13, product.getSize());
            ps.setString(14, product.getCuttingGrindingShape());
            ps.setString(15, product.getMaterial());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Product product) {
        String sql = "update products set category_id=?, product_name=?,  price=?, status=?, " +
                "thumbnail_id=?, sale=?, hot=?, description=?,  updated_at=CURRENT_TIME, " +
                "color=?, weight=?, opacity=?,  size=?, " +
                "cutting_grinding_type=?, material=? where id=?;";
        try {
            PreparedStatement ps = MySqlConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, product.getCategoryID());
            ps.setString(2, product.getProductName());
            ps.setInt(3, product.getPrice());
            ps.setString(4, product.getStatus());
            ps.setInt(5, product.getThumbnailID());
            ps.setInt(6, product.getSale());
            ps.setBoolean(7, product.isHot());
            ps.setString(8, product.getDescription());
            ps.setString(9, product.getStoneColor());
            ps.setString(10, product.getWeight());
            ps.setString(11, product.getOpacity());
            ps.setString(12, product.getSize());
            ps.setString(13, product.getCuttingGrindingShape());
            ps.setString(14, product.getMaterial());
            ps.setInt(15, product.getId());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
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

    public Product getProductByID(int productId) {
        Product product = null;
        try {
            String query = "SELECT p.id, p.product_name, p.price, p.status, p.description, i.img_url, inv.quantity " +
                    "FROM products p " +
                    "JOIN images i ON p.thumbnail_id = i.id " +
                    "JOIN inventories inv ON p.id = inv.product_id " +
                    "WHERE p.id = ?";
            Connection con = MySqlConnection.getConnection();
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, productId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int id = rs.getInt("id");
                        String productName = rs.getString("product_name");
                        int price = rs.getInt("price");
                        String status = rs.getString("status");
                        String description = rs.getString("description");
                        String imgURL = rs.getString("img_url");
                        Integer quantity = (Integer) rs.getObject("quantity");

                        if (quantity == null) {
                            status = "Ngừng bán";
                        } else {
                            status = (quantity >= 1) ? "Đặt hàng" : "Hết hàng";
                        }

                        product = new Product(id, productName, price, status, description, imgURL);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
    public  ArrayList<Product> getListProductFull(){
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select p.id, p.product_name, c.category_name, " +
                    "i.img_url, p.price, p.sale, p.hot, p.description, p.created_at, " +
                    "p.updated_at, p.deleted_at, p.color, p.weight, p.size, " +
                    "p.opacity, p.status, p.cutting_grinding_type, p.material " +
                    "from products p JOIN images i on p.thumbnail_id=i.id " +
                    "join categories c on p.category_id=c.id;";
            Connection con = MySqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            /*
            * Product(int id, String productName, int categoryID, String imgURL,
                   int price, int sale, boolean hot, String description,
                   Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt,
                   String color, String weight, String size, String opacity,
                   String status, String cuttingGrindingShape, String marterial
            * */
            while (rs.next()) {
                Product product=new Product();
                product.setId(rs.getInt("id"));
                product.setProductName(rs.getString("product_name"));
                product.setCategoryName(rs.getString("category_name"));
                product.setImgURL(rs.getString("img_url"));
                product.setPrice(rs.getInt("price"));
                product.setSale(rs.getInt("sale"));
                product.setHot(rs.getBoolean("hot"));
                product.setDescription(rs.getString("description"));
                product.setCreatedAt(rs.getTimestamp("created_at"));
                product.setUpdatedAt(rs.getTimestamp("updated_at"));
                product.setDeletedAt(rs.getTimestamp("deleted_at"));
                product.setStoneColor(rs.getString("color"));
                product.setWeight(rs.getString("weight"));
                product.setSize(rs.getString("size"));
                product.setOpacity(rs.getString("opacity"));
                product.setStatus(rs.getString("status"));
                product.setCuttingGrindingShape(rs.getString("cutting_grinding_type"));
                product.setMaterial(rs.getString("material"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    public static void main(String[] args) throws SQLException {
        ProductDAO productDAO = new ProductDAO();
        System.out.println(productDAO.getThumbnail("VIÊN SPINEL HỒNG DÂU LỤC YÊN 3,56CT"));

    }
    public ResultSet getProductQuantity() throws SQLException {
        String sql = "select p.id, p.product_name, p.price from products p";
        PreparedStatement ps = MySqlConnection.getConnection().prepareStatement(sql);

        return ps.executeQuery();
    }
    public int getMaxID() throws SQLException {
        int max=0;
        String sql="SELECT MAX(p.id) from products p;";
        PreparedStatement ps=MySqlConnection.getConnection().prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            max=rs.getInt(1);
        }
        return max;
    }
    public ArrayList<Product>getProductWithInventories() throws SQLException {
        String sql="select p.id, p.product_name, p.created_at, " +
                "i.quantity from products p join " +
                "inventories i on p.id=i.product_id;";
        PreparedStatement ps=MySqlConnection.getConnection().prepareStatement(sql);
        ArrayList<Product>products=new ArrayList<>();
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            Product product=new Product();
            product.setId(rs.getInt("id"));
            product.setProductName(rs.getString("product_name"));
            product.setCreatedAt(rs.getTimestamp("created_at"));
            product.setQuantity(rs.getInt("quantity"));
            products.add(product);
        }
        return products;
    }
    public int findIdProduct(String productname) throws SQLException {
        String sql = "select id from  products  where products.product_name=?";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1, productname);
        ResultSet rs = pr.executeQuery();

        int id = 0;
        while (rs.next()) {
            id = rs.getInt("id");
        }
        return id;
    }
    public String getThumbnail(String productname) throws SQLException {
        String sql = "select img_url from images join products on images.id=products.thumbnail_id where products.product_name=?";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1, productname);
        ResultSet rs = pr.executeQuery();
        String img = "";
        while (rs.next()) {
            img = rs.getString("img_url");
        }
        return img;
    }
}
