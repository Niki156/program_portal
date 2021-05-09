package com.epam.programs_portal.tests.smoke_test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.framework.browser_factory.BrowserFactory;
import com.epam.framework.browser_factory.DriverType;
import com.epam.framework.browser_functions.BrowserReusableFunctions;
import com.epam.program_portal.constants.URLS;
import com.epam.program_portal.constants.page_constants.SignUpPageConstants;
import com.epam.program_portal.web.pages.SignUpPage;

public class SignUpSmokeTestCase {
	WebDriver driver;
	SignUpPage signUpPage;
	
	@BeforeClass
	public void openSignUpPage()
	{

		driver = BrowserFactory.getDriver(DriverType.CHROME);
		signUpPage = new SignUpPage(driver).launchBrowserWithSignUpPage();
	}
	
	@Test
	public void isSignUpPageOpening()
	{
		assertEquals(signUpPage.getCurrentURL(), URLS.SIGN_UP_URL);
	}
	
	@Test
	public void isEmailIconVisible()
	{
		assertTrue(BrowserReusableFunctions.isElementPresentWithXpath(driver, SignUpPageConstants.EMAIL_ICON_XPATH), "Email Icon not visible");
		
	}
	
	@Test
	public void isPasswordIconVisible()
	{
		assertTrue(BrowserReusableFunctions.isElementPresentWithXpath(driver, SignUpPageConstants.PASSWORD_ICON_XPATH), "Password Icon not visible");
		
	}
	@Test
	public void isSignUpHeadingVisible()
	{
		assertEquals(BrowserReusableFunctions.getTextFromElementByXpath(driver,  SignUpPageConstants.SIGN_UP_HEADING_XPATH), "SIGN UP");
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
}
