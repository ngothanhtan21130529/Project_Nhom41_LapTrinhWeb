package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAOInterface<T> {
    public int insert(T t) throws SQLException;
    public int update(T t);
    public int delete(T t);
    public T selectById(T t);
    public ArrayList<T> selectByCondition(String condition);
}
