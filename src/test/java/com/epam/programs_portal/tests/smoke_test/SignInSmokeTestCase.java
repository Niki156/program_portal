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
import com.epam.program_portal.constants.page_constants.SignInPageConstants;
import com.epam.program_portal.web.pages.SignInPage;
import com.epam.program_portal.web.pages.SignUpPage;

public class SignInSmokeTestCase {

	WebDriver driver;
	SignInPage signInPage;

	@BeforeClass
	public void openSignUpPage() {
		driver = BrowserFactory.getDriver(DriverType.CHROME);
		signInPage = new SignUpPage(driver).signup();
	}

	@Test
	public void isSignUpPageOpening() {
		assertEquals(signInPage.getCurrentURL(), URLS.SIGN_IN_URL);
	}

	@Test
	public void isEmailIconVisible() {
		assertTrue(BrowserReusableFunctions.isElementPresentWithXpath(driver, SignInPageConstants.EMAIL_ICON_XPATH),
				"Email Icon not visible");

	}

	@Test
	public void isPasswordIconVisible() {
		assertTrue(BrowserReusableFunctions.isElementPresentWithXpath(driver, SignInPageConstants.PASSWORD_ICON_XPATH),
				"Password Icon not visible");

	}

	@Test
	public void isSignInHeadingVisible() {
		assertEquals(
				BrowserReusableFunctions.getTextFromElementByXpath(driver, SignInPageConstants.SIGN_IN_HEADING_XPATH),
				"SIGN IN");
	}

	@Test
	public void isForgotPasswordVisible() {
		assertTrue(
				BrowserReusableFunctions.isElementPresentWithXpath(driver, SignInPageConstants.FORGOT_PASSWORD_XPATH));
	}

	@Test
	public void checkForgotPasswordText() {
		assertEquals(
				BrowserReusableFunctions.getTextFromElementByXpath(driver, SignInPageConstants.FORGOT_PASSWORD_XPATH),
				"Forgot Password?");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
