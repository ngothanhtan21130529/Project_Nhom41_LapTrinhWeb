package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.model.Inventory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InventoriesDAO implements DAOInterface<Inventory> {
    @Override
    public int insert(Inventory inventory) {
        String sql="insert into inventories (id, product_id, quantity) values (?,?,?)";
        try {
            PreparedStatement ps=MySqlConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, inventory.getId());
            ps.setInt(2,inventory.getProductId());
            ps.setInt(3,inventory.getQuantity());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Inventory inventory) {
        String sql="update inventories i set i.product_id=?, i.quantity=? where i.id=?";
        try {
            PreparedStatement ps=MySqlConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, inventory.getProductId());
            ps.setInt(2, inventory.getQuantity());
            ps.setInt(3, inventory.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(Inventory inventory) {
        return 0;
    }

    @Override
    public Inventory selectById(Inventory inventory) {
        return null;
    }

    @Override
    public ArrayList<Inventory> selectByCondition(String condition) {
        return null;
    }
    public int getMaxID() throws SQLException {
        int max=0;
        String sql="SELECT count(i.id) from inventories i;";
        PreparedStatement ps= MySqlConnection.getConnection().prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            max=rs.getInt(1);
        }
        return max;
    }
    public ArrayList<Inventory>getInventoriesList() throws SQLException {
        String sql="select i.id, i.product_id, " +
                "i.quantity from inventories i;";
        PreparedStatement ps=MySqlConnection.getConnection().prepareStatement(sql);
        ArrayList<Inventory>inventoryArrayList=new ArrayList<>();
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Inventory inventory=new Inventory();
            inventory.setId(rs.getInt(1));
            inventory.setProductId(rs.getInt(2));
            inventory.setQuantity(rs.getInt(3));
            inventoryArrayList.add(inventory);
        }
        return inventoryArrayList;
    }
}
