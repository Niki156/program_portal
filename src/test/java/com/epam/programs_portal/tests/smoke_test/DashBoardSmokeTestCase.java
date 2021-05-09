package com.epam.programs_portal.tests.smoke_test;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.epam.framework.browser_factory.BrowserFactory;
import com.epam.framework.browser_factory.DriverType;
import com.epam.framework.browser_functions.BrowserReusableFunctions;
import com.epam.framework.listeners.TestListener;
import com.epam.program_portal.constants.page_constants.DashBoardConstants;
import com.epam.program_portal.web.pages.DashBoard;
@Listeners(TestListener.class)
public class DashBoardSmokeTestCase {
	WebDriver driver;
	DashBoard dashboard;
	@BeforeClass
	public void setup(ITestContext context)
	{
		driver = BrowserFactory.getDriver(DriverType.CHROME);
		context.setAttribute("driver", driver);
		dashboard = new DashBoard(driver).getDashBoard();
	}
	//@Test
	/*public void testTotalBatchesCard()
	{
		BrowserReusableFunctions.waitUntilElementIsVisibleByXpath(driver, DashBoardConstants.TOTAL_BATCHES_DIV_XPATH);
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(BrowserReusableFunctions.isElementPresentWithXpath(driver, DashBoardConstants.TOTAL_BATCHES_DIV_XPATH));
		softassert.assertTrue(BrowserReusableFunctions.isElementPresentWithXpath(driver,DashBoardConstants.TOTAL_BATCHES_DIV_ICON_XPATH));
		softassert.assertTrue(BrowserReusableFunctions.isElementPresentWithXpath(driver, DashBoardConstants.TOTAL_BATCHES_COUNT_XPATH));
		softassert.assertAll();
		
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}*/
	
	
	
	
	
	
	@Test
	public void ansdkjf()
	{
		assertFalse(true);
	}

}
