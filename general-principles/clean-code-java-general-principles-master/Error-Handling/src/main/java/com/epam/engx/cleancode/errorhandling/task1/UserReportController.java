package com.epam.engx.cleancode.errorhandling.task1;

import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.Model;
import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.NullException;

public class UserReportController {

    private UserReportBuilder userReportBuilder;

    public String getUserTotalOrderAmountView(String userId, Model model){
        String totalMessage = getUserTotalMessage(userId);
        if(totalMessage.equals("technicalError"))
        	return "technicalError";
        model.addAttribute("userTotalMessage", totalMessage);
        return "userTotal";
    }

    private String getUserTotalMessage(String userId) {
    	
    	Double amount;
       try
       {
    	   amount = userReportBuilder.getUserTotalOrderAmount(userId);
       }
       catch(NullException e)
       {
    	   return String.valueOf(e);
       } 
       return "User Total: " + amount + "$";
    }


    public UserReportBuilder getUserReportBuilder() {
        return userReportBuilder;
    }

    public void setUserReportBuilder(UserReportBuilder userReportBuilder) {
        this.userReportBuilder = userReportBuilder;
    }
}
