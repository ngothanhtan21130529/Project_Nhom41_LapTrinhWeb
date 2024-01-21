package DAO;

import connection.MySqlConnection;
import model.Comment;
import model.Feedback;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackDAO {
    public static FeedbackDAO getInstance(){
        return new FeedbackDAO();
    }
    public boolean insertFeedback(Feedback feedback) throws SQLException {
        String sql="Insert into feedbacks(full_name,email,phone,title,feedback_content)values(?,?,?,?,?)";

        PreparedStatement preparedStatement= MySqlConnection.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, feedback.getFullName());
        preparedStatement.setString(2, feedback.getEmail());
        preparedStatement.setString(3,feedback.getPhone());
        preparedStatement.setString(4,feedback.getTitle());
        preparedStatement.setString(5,feedback.getContent());
        int i=preparedStatement.executeUpdate();
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
}
