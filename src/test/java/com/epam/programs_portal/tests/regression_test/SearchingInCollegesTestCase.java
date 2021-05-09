package com.epam.programs_portal.tests.regression_test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.framework.browser_factory.BrowserFactory;
import com.epam.framework.browser_factory.DriverType;
import com.epam.program_portal.web.pages.CollegesInMDM;
import com.epam.programs_portal.data_provider.DataProviderSource;
import com.epam.programs_portal.mostly_used_variables.UserCredentials;


public class SearchingInCollegesTestCase implements UserCredentials {

	WebDriver driver;
	CollegesInMDM collegePage;

	@Test
	public void launchBrowser() {
		driver = BrowserFactory.getDriver(DriverType.CHROME);
		collegePage = new CollegesInMDM(driver).getCollegesPage();
	}

	@Test(dataProvider = "sendDataForSearchBox", dataProviderClass = DataProviderSource.class, dependsOnMethods="launchBrowser")
	public void search(String search) throws InterruptedException {
		System.out.println("search class The thread ID for Chrome is " + Thread.currentThread().getId());
		collegePage.search(search);
		collegePage.setDisplayEntryCount("100");
		Thread.sleep(5000);
		Assert.assertFalse(collegePage.isSearchResultsInvalid(search), "invalid search results");
	}

	

	@Test(dependsOnMethods="search")
	public void tearDown() throws InterruptedException {
		driver.close();
	}

}
