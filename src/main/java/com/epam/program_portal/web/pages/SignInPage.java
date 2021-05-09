package com.epam.program_portal.web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.epam.framework.browser_functions.BrowserReusableFunctions;
import com.epam.program_portal.constants.URLS;
import com.epam.program_portal.utility_functions.UserPropertiesUtilities;


public class SignInPage {
	private WebDriver driver;
	static Logger logger = LogManager.getLogger(SignInPage.class);
	
	@FindBy(how = How.ID, using = "exampleInputEmail1")
	@CacheLookup
    WebElement userName;
	
	@FindBy(how = How.ID, using = "exampleInputPassword1")
	@CacheLookup
    WebElement password;
	
	@FindBy(how = How.ID, using = "form_submit")
	@CacheLookup
    WebElement signInButton;
	
    private String signInURL = URLS.SIGN_IN_URL;
    
    public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
    public SignInPage launchBrowserWithSignInPage()
    {
    	logger.info("launching sign in page");
    	driver.get(signInURL);
    	return new SignInPage(driver);
    }
    
    public void enterUserName(String email)
    {
    	userName.sendKeys(email);
    }
    
    public void enterPassword(String passWord)
    {
    	password.sendKeys(passWord);
    }
    public boolean isSignInButtonEnabled()
    {
    	return signInButton.isEnabled();
    }
    public void clickOnSigninButton()
    {
    	BrowserReusableFunctions.clickButton(driver, signInButton);
    }
    
    public DashBoard signIn()
    {
    	logger.debug(("signing with user name: "+UserPropertiesUtilities.getUsername()));
    	launchBrowserWithSignInPage();
    	enterUserName(UserPropertiesUtilities.getUsername());
    	enterPassword(UserPropertiesUtilities.getPassword());
    	clickOnSigninButton();
    	logger.debug("signin complete");
    	return new DashBoard(driver);
    }
    public DashBoard signIn(String email, String password)
    {
    	logger.debug("signing with user name: "+email);
    	launchBrowserWithSignInPage();
    	enterUserName(email);
    	enterPassword(password);
    	clickOnSigninButton();
    	logger.debug("signin complete");
    	return new DashBoard(driver);
    }
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
     
}
