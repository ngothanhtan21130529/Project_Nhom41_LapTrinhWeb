package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.model.Feedback;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FeedbackDAO implements DAOInterface<Feedback> {
    public static FeedbackDAO getInstance() {
        return new FeedbackDAO();
    }

    public boolean insertFeedback(Feedback feedback) throws SQLException {
        String sql = "Insert into feedbacks(id,full_name,email,phone,title,feedback_content,created_at) values(?,?,?,?,?,?,CURRENT_TIMESTAMP)";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        pr.setInt(1,getMaxID()+1);
        pr.setString(2, feedback.getFullName());
        pr.setString(3,feedback.getEmail());
        pr.setString(4,feedback.getPhone());
        pr.setString(5, feedback.getTitle());
        pr.setString(6, feedback.getContent());
        int i=pr.executeUpdate();
        pr.close();
        MySqlConnection.getConnection().close();
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    public int getMaxID() throws SQLException {
        String sql = "SELECT MAX(id) AS max_id FROM feedbacks";
        try (PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
             ResultSet rs = pr.executeQuery()) {

            int res = 0;
            while (rs.next()) {
                res = rs.getInt("max_id"); // Sử dụng tên cột được đặt bởi AS
            }
            return res;
        }
    }


    @Override
    public int insert(Feedback feedback) {
        return 0;
    }

    @Override
    public int update(Feedback feedback) {
        return 0;
    }

    @Override
    public int delete(Feedback feedback) {
        return 0;
    }

    @Override
    public Feedback selectById(Feedback feedback) {
        return null;
    }

    @Override
    public ArrayList<Feedback> selectByCondition(String condition) {
        return null;
    }

    public static void main(String[] args) {
        FeedbackDAO feedbackDAO=new FeedbackDAO();
        try {
            System.out.println(feedbackDAO.getMaxID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Feedback> getFullListFeedBack() throws SQLException {
        String sql="select f.id, f.full_name, f.email, f.phone, f.title, f.feedback_content, f.created_at from feedbacks f;";
        PreparedStatement ps=MySqlConnection.getConnection().prepareStatement(sql);
        ArrayList<Feedback>feedbackArrayList=new ArrayList<>();
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Feedback feedback=new Feedback();
            feedback.setId(rs.getInt("id"));
            feedback.setFullName(rs.getString("full_name"));
            feedback.setEmail(rs.getString("email"));
            feedback.setPhone(rs.getString("phone"));
            feedback.setTitle(rs.getString("title"));
            feedback.setContent(rs.getString("feedback_content"));
            feedback.setCreatedAt(rs.getTimestamp("created_at"));
            feedbackArrayList.add(feedback);
        }
        return feedbackArrayList;
    }
}


