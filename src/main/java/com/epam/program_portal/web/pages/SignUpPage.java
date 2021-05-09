package com.epam.program_portal.web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.epam.program_portal.constants.URLS;
import com.epam.program_portal.utility_functions.UserPropertiesUtilities;


public class SignUpPage {
	private WebDriver driver;
	private String signUpURL = URLS.SIGN_UP_URL;
	static Logger logger = LogManager.getLogger(SignUpPage.class);

	@FindBy(how = How.ID, using = "exampleInputEmail1")
	@CacheLookup
	WebElement userName;

	@FindBy(how = How.ID, using = "exampleInputPassword1")
	@CacheLookup
	WebElement password;

	@FindBy(how = How.ID, using = "form_submit")
	@CacheLookup
	WebElement signUpButton;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}

	
	public SignUpPage launchBrowserWithSignUpPage() {
		logger.info("Launching signup page");
		driver.get(signUpURL);
		return new SignUpPage(driver);
	}

	public void enterUserName(String email) {
		userName.sendKeys(email);
	}
	
	public void enterPassword(String passWord) {
		password.sendKeys(passWord);
	}

	public boolean isSignUpButtonEnabled() {
		return signUpButton.isEnabled();
	}
	
	public String getCurrentURL()
	{
		return driver.getCurrentUrl();
	}

	public void clickOnSignupButton() {
		if (signUpButton.isEnabled())
			signUpButton.click();
		else
			logger.error("SignUp button is disabled");
	}
	
	public SignInPage signup() {
		launchBrowserWithSignUpPage();
		enterUserName(UserPropertiesUtilities.getUsername());
		enterPassword(UserPropertiesUtilities.getPassword());
		clickOnSignupButton();
		return new SignInPage(driver);

	}

	public SignInPage signup(String email, String password) {
		launchBrowserWithSignUpPage();
		enterUserName(email);
		enterPassword(password);
		clickOnSignupButton();
		return new SignInPage(driver);

	}
}
