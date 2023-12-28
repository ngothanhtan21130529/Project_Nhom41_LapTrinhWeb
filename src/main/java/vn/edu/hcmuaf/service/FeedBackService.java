package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.FeedbackDAO;
import vn.edu.hcmuaf.model.Feedback;

public class FeedBackService {
    public  boolean insertFeedBack(Feedback feedback){
        FeedbackDAO feedbackDAO=FeedbackDAO.getInstance();
        return true;
    }
}
