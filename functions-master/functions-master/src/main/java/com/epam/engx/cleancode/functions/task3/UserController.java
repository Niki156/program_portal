package com.epam.engx.cleancode.functions.task3;

import com.epam.engx.cleancode.functions.task3.thirdpartyjar.Controller;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.User;

public abstract class UserController implements Controller {
	private String userName="";
    private UserAuthenticator userAuthenticator;
    private void generateResponse(User user)
    {
    	if (user == null)
            generateFailLoginResponse();
        else
            generateSuccessLoginResponse(userName);
    }

    public void authenticateAndGenerateResponse(String userName, String password) {
    	this.userName=userName;
        User user = userAuthenticator.login(userName, password);
        generateResponse(user);
    }

    public void setUserAuthenticator(UserAuthenticator userAuthenticator) {
        this.userAuthenticator = userAuthenticator;
    }
}
