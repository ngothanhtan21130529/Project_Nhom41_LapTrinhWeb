package test;

import DAO.CategoryDAO;
import DAO.ProductDAO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class testDAO {
    public static void main(String[] args) {
        System.out.println(ProductDAO.getInstance().count("a"));
    }
}
