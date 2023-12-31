package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.model.Feedback;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackDAO implements Serializable {
    public static FeedbackDAO getInstance() {
        return new FeedbackDAO();
    }

    public boolean insertFeedback(Feedback feedback) throws SQLException {

        String sql = "Insert into feedbacks(id,full_name,email,phone,title,feedback_content,created_at) values(?,?,?,?,?,?,CURRENT_TIMESTAMP)";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        pr.setInt(1,this.getMaxID());
        pr.setString(2, feedback.getFullName());
        pr.setString(3,feedback.getEmail());
        pr.setString(4,feedback.getPhone());
        pr.setString(5, feedback.getTitle());
        pr.setString(6, feedback.getContent());
        int i=pr.executeUpdate();
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    public  int getMaxID() throws SQLException {
        String sql = "Select max(id) from feedbacks";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pr.executeQuery();
        int res=0;
        while (rs.next()) {
            res=rs.getInt("id");
        }
        return res;
    }
}
