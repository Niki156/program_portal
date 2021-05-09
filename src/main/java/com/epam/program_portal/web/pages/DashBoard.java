package com.epam.program_portal.web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.epam.framework.browser_functions.BrowserReusableFunctions;
import com.epam.program_portal.constants.page_constants.DashBoardConstants;



public class DashBoard {
	private WebDriver driver;
	static Logger logger = LogManager.getLogger(DashBoard.class);
	
	@FindBy(how = How.CLASS_NAME, using=DashBoardConstants.TOGGLE_BOX_CLASS_PATH)
	WebElement toggleBox;
	
	@FindBy(how= How.XPATH, using = DashBoardConstants.MDM_TEXT_XPATH)
	WebElement masterDataManagement;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using="Colleges")
	WebElement collegesButton;
	
	public DashBoard(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public DashBoard getDashBoard() {
		logger.info("Opening dashboard with default credentials..");
		return new SignUpPage(driver).signup().signIn();
	}
	public DashBoard getDashBoard(String email, String password) {
		logger.info("Opening dashboard with the dynamic params..");
		return new SignUpPage(driver).signup(email, password).signIn(email, password);
	}
	
	public DashBoard clickOnToggleButton()
	{
		logger.debug("clicked on toggle button");
		BrowserReusableFunctions.clickWebElement(driver, toggleBox);
		return new DashBoard(driver);
	}
	public DashBoard clickMasterDataManagementLink()
	{
		logger.debug("clicked on master data management link");
		BrowserReusableFunctions.clickWebElement(driver, masterDataManagement);
		return new DashBoard(driver);
	}
	public CollegesInMDM clickOnColleges()
	{
		logger.debug("clicked on colleges");
		BrowserReusableFunctions.clickWebElement(driver, collegesButton);
		return new CollegesInMDM(driver);
	}
	
	
}
