package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.dao.UserDAO;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.model.User;
import vn.edu.hcmuaf.dao.UserDAO;


import java.sql.SQLException;

public class UserService {
    private UserDAO dao=new UserDAO();
    public int getUserId(String username) throws SQLException {
        UserDAO userDAO = UserDAO.getInstance();
        return userDAO.getUserid(username);
    }
    public void addProduct(User user) throws SQLException {
        dao.insertUser(user);
    }
    public UserDAO getUserDAO(){
        return UserDAO.getInstance();
    }
    public void deleteProduct(User user){
        dao.delete(user);
    }
    public void updateProduct(User user){
        dao.update(user);
    }
    public int getMaxID() throws SQLException {
        return dao.getMaxID()+1;
    }
}
