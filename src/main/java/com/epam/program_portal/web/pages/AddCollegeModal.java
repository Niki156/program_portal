package com.epam.program_portal.web.pages;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.epam.framework.browser_functions.BrowserReusableFunctions;
import com.epam.program_portal.api.beans.College;


public class AddCollegeModal {
	
	static Logger logger = LogManager.getLogger(AddCollegeModal.class);
	private WebDriver driver;
	@FindBy(how = How.NAME, using = "collegeName")
	WebElement collegeName;
	
	@FindBy(how = How.NAME, using="collegeGroup")
	WebElement collegeGroup;
	
	@FindBy(how = How.NAME, using="collegeCity")
	WebElement collegeCity;
	
	@FindBy(how = How.NAME, using="collegePtoName")
	WebElement collegePtoName;
	
	@FindBy(name="collegePtoEmail")
	WebElement collegePtoEmail;
	
	@FindBy(name="collegeDesc")
	WebElement collegePtoMobile;
	
	String errorElementCSSPath = "div.row div div div";
	
	
	@FindBy(how = How.CSS, using="div.modal-footer button.lime-green")
	WebElement submitButton ;
	@FindBy(how = How.XPATH, using="//button[text()='Cancel']")
	WebElement cancelButton;
	
	
	
	public AddCollegeModal(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public void sendCollegeName(String clgName)
	{
		BrowserReusableFunctions.sendKeys(driver, collegeName, clgName);
	}
	public void sendCollegeGroup(String clgGroup)
	{
		BrowserReusableFunctions.sendKeys(driver, collegeGroup, clgGroup);
	}
	public void sendCollegeCity(String city)
	{
		BrowserReusableFunctions.sendKeys(driver, collegeCity, city);
	}
	public void sendCollegePTOName(String name)
	{
		BrowserReusableFunctions.sendKeys(driver, collegePtoName, name);
	}
	public void sendCollegePTOEmail(String email)
	{
		BrowserReusableFunctions.sendKeys(driver, collegePtoEmail, email);
	}
	public void sendCollegePTOMobile(String mobileNumber)
	{
		BrowserReusableFunctions.sendKeys(driver, collegePtoMobile, mobileNumber);
	}
	public boolean isSaveButtonEnabled()
	{
		return submitButton.isEnabled();
	}
	
	//clicks on submit or cancel based on the data validity
	public CollegesInMDM clickSubmit()
	{
		BrowserReusableFunctions.clickButton(driver, submitButton);
		return new CollegesInMDM(driver);
	}
	public CollegesInMDM clickCancel()
	{
		BrowserReusableFunctions.clickButton(driver, cancelButton);
		return new CollegesInMDM(driver);
	}
	public boolean checkIfAnyWarnings()
	{
		 if(BrowserReusableFunctions.isElementPresentWithCSS(driver, errorElementCSSPath))
		 {
			 List<WebElement> list = driver.findElements(By.cssSelector(errorElementCSSPath));
			 for(WebElement element: list)
				 logger.warn(element.getText());
			 return true;
		 }
		 else
		 {
			 logger.debug("No warnings found");
			 return false;
		 }
	}
	public void addCollegeDetails(College college)
	{
		logger.debug("Entering college details");
		sendCollegeName(college.getCollegeName());
		sendCollegeGroup(college.getGroup());
		sendCollegeCity(college.getCity());
		sendCollegePTOName(college.getPtoName());
		sendCollegePTOEmail(college.getPtoEmail());
		sendCollegePTOMobile(college.getPtoMobile());
		logger.debug("entering college details complete");
		checkIfAnyWarnings();
		
	}
	

}
