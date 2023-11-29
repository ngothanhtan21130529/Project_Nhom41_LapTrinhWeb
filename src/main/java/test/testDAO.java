package test;

import DAO.CategoryDAO;
import model.Category;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class testDAO {
    public static void main(String[] args) {
        Category category1 = new Category(1, "da quy", new Timestamp(new Date(122, 5, 6).getTime()), new Timestamp(new Date(122, 5, 10).getTime()));
        Category category2 = new Category(2, "trang suc", new Timestamp(new Date(122, 10, 1).getTime()), new Timestamp(new Date(122, 10, 1).getTime()));

        CategoryDAO.getInstance().delete(category1);
        CategoryDAO.getInstance().delete(category2);

        CategoryDAO.getInstance().insert(category1);
        CategoryDAO.getInstance().insert(category2);

        System.out.println("-----------------");
        Category find=new Category();
        find.setId(1);
        Category categoryExample1=CategoryDAO.getInstance().selectById(find);
        System.out.println(categoryExample1);

        System.out.println("-----------------");
        ArrayList<Category>list2=CategoryDAO.getInstance().selectByCondition("create_at < '2023-06-07'");
        for (Category category : list2) {
            System.out.println(category);
        }
    }
}
