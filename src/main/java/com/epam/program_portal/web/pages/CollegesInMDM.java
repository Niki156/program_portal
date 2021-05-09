package com.epam.program_portal.web.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.epam.framework.browser_functions.BrowserReusableFunctions;


public class CollegesInMDM {
	
	private WebDriver driver;
	static Logger logger = LogManager.getLogger(CollegesInMDM.class);
	
	
	@FindBy(how = How.XPATH, using="//div[@class='panel-heading']  //button[ @data-target='#addCollegeModal']")
	WebElement addCollegeBy;
	
	@FindBy(how = How.XPATH, using="//input[@type='search']")
	WebElement searchBox ;

	@FindBy(how = How.XPATH, using="//select['CollegeTable_length']")
	WebElement displayEntriesCount;

	private By tableDataCSSPath = By.cssSelector("tbody tr");

	public CollegesInMDM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public CollegesInMDM getCollegesPage()
	{
		logger.info("Opening Colleges Page..");
		return new DashBoard(driver).getDashBoard().clickOnToggleButton().clickMasterDataManagementLink().clickOnColleges();
	}

	public AddCollegeModal clickOnAddCollege() {
		BrowserReusableFunctions.clickWebElement(driver, addCollegeBy);
		return new AddCollegeModal(driver);
	}

	public CollegesInMDM search(String searchKey) {
		BrowserReusableFunctions.sendKeys(driver, searchBox, searchKey);
		return new CollegesInMDM(driver);
	}

	public void setDisplayEntryCount(String value) {
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS); 
		Select entries = new Select(displayEntriesCount);
		entries.selectByValue(value);
	}

	public boolean isDataEmpty() {
		return (driver.findElements(tableDataCSSPath).size() == 1
				&& driver.findElements(tableDataCSSPath).get(0).getText().equals("No data!"));


	}

	public boolean isFetchedRowAInvalidSearch(WebElement row, String searchKey) {
		String lowerCaseSearchKey = searchKey.toLowerCase();
		List<WebElement> columns = row.findElements(By.tagName("td"));
		boolean foundAValidResult = false;
		for (WebElement column : columns) {
			if (column.getText().toLowerCase().contains(lowerCaseSearchKey)) {
				foundAValidResult = true;
				break;
			}
		}
		return !foundAValidResult;
	}

	public boolean isSearchResultsInvalid(String searchKey) {
		return !(isSearchResultsValid(searchKey));
	}

	public boolean isSearchResultsValid(String searchKey) {
		
		if(isDataEmpty())
		{
			 logger.info("Empty Data results for the search key: "+searchKey);
			 return true;
		}
			
		logger.info("search results validity function is invoked");
		List<WebElement> rows = driver.findElements(tableDataCSSPath);
		boolean isResultsValid = true;
		for (WebElement row : rows) {
			if (isFetchedRowAInvalidSearch(row, searchKey)) {
				logger.error("test failed for the row: " + row.getText() + " key is: " + searchKey);
				isResultsValid=false;
				break;
			}
		}
		if(!isResultsValid)
			logger.error("search results are invalid for search key: "+searchKey);
		else
			logger.debug("Valid search results for the search key: "+searchKey);
		return isResultsValid;
	}

}
