package com.epam.programs_portal.tests.regression_test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.framework.browser_factory.BrowserFactory;
import com.epam.framework.browser_factory.DriverType;
import com.epam.framework.browser_functions.BrowserReusableFunctions;
import com.epam.program_portal.constants.URLS;
import com.epam.program_portal.constants.page_constants.DashBoardConstants;
import com.epam.program_portal.web.pages.SignUpPage;
import com.epam.programs_portal.data_provider.DataProviderSource;


public class SignInTestCase {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver = BrowserFactory.getDriver(DriverType.CHROME);
				
	}

	@Test(dataProvider = "credentialsForSignUpandSignIn", dataProviderClass = DataProviderSource.class)
	public void signIn(String email, String password) throws InterruptedException {
		
		System.out.println("SignIn and Signup test class The thread ID for Chrome is " + Thread.currentThread().getId());
		new SignUpPage(driver).signup(email, password).signIn(email, password);
		BrowserReusableFunctions.waitUntilElementIsVisibleByXpath(driver, DashBoardConstants.BATCHES_WEBELEMENT_XPATH);
		Assert.assertEquals(driver.getCurrentUrl() ,URLS.DASHBOARD_URL);
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	

}
