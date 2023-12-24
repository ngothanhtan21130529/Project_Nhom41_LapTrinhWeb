package DAO;

import connection.MySqlConnection;
import model.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentDAO implements DAOInterface{
    public static CommentDAO getInstance(){
        return new CommentDAO();
    }
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
    public void insertComment(Comment comment) throws SQLException {
       Connection c= MySqlConnection.getConnection();

    }
}
