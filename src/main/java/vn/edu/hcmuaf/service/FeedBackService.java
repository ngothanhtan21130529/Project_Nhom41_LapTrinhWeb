package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.FeedbackDAO;
import vn.edu.hcmuaf.model.Feedback;

import java.sql.SQLException;

public class FeedBackService {
    public  boolean insertFeedBack(Feedback feedback) throws SQLException {
        FeedbackDAO feedbackDAO=FeedbackDAO.getInstance();
        if(feedbackDAO.insertFeedback(feedback)){
            return true;
        }else{
            return false;
        }

    }
}
