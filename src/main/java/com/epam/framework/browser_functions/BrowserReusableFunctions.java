package com.epam.framework.browser_functions;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.program_portal.constants.DateConstants;
import com.epam.program_portal.constants.DriverConstants;

public class BrowserReusableFunctions {
	
	private BrowserReusableFunctions(){}
	
	public static void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	public static void defaultImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(DriverConstants.DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
	}
	public static String getTextFromElementByXpath(WebDriver driver, String xpath)
	{
		waitUntilElementIsVisibleByXpath(driver, xpath);
		return driver.findElement(By.xpath(xpath)).getText();
	}
	public static boolean checkIfElementIsPresentWithBy(WebDriver driver, By by)
	{
		try {
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException exception)
		{
			return false;
		}
	}
	public static boolean isElementPresentWithCSS(WebDriver driver, String cssPath)
	{
		return checkIfElementIsPresentWithBy(driver, By.cssSelector(cssPath));
	}
	public static boolean isElementPresentWithXpath(WebDriver driver, String xpath)
	{
		return checkIfElementIsPresentWithBy(driver, By.xpath(xpath));
	}
	public static void waitUntilElementIsVisible(WebDriver driver, WebElement webElement)
	{
		WebDriverWait wait = new WebDriverWait(driver, DriverConstants.DEFAULT_WAIT_TIME);
		wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(webElement));

	}
	public static void waitUntilElementIsVisibleByXpath(WebDriver driver, String xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, DriverConstants.DEFAULT_WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		
	}
	public static void waitUntilElementIsClickable(WebDriver driver, WebElement webElement)
	{
		WebDriverWait wait = new WebDriverWait(driver, DriverConstants.DEFAULT_WAIT_TIME);
		wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(webElement));
	}
	public static void clickButton(WebDriver driver, WebElement webElement)
	{
		waitUntilElementIsClickable(driver, webElement);
		webElement.click();
	}
	public static void clickWebElement(WebDriver driver, WebElement webElement)
	{
		waitUntilElementIsVisible(driver, webElement);
		webElement.click();
	}
	public static void sendKeys(WebDriver driver, WebElement webElement, String keys)
	{
		waitUntilElementIsVisible(driver, webElement);
		webElement.clear();
		webElement.sendKeys(keys);
	}
	@SuppressWarnings("deprecation")
	public static void takeScreenShot(WebDriver	driver, String name) throws IOException
	{
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		String parent = DateConstants.monthName[date.getMonth()] +"_"+DateConstants.dayName[date.getDay()];
		FileUtils.copyFile(screenshot, new File("test-output/screenshots/"+parent+"/"+name+date.toString().replace(" ", "_").replace(":", "_")+".png"));
		 
	}
}
