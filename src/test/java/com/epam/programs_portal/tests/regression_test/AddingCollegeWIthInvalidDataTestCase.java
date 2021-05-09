package com.epam.programs_portal.tests.regression_test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.framework.browser_factory.BrowserFactory;
import com.epam.framework.browser_factory.DriverType;
import com.epam.program_portal.api.beans.College;
import com.epam.program_portal.web.pages.AddCollegeModal;
import com.epam.program_portal.web.pages.CollegesInMDM;
import com.epam.programs_portal.data_provider.DataProviderSource;
import com.epam.programs_portal.mostly_used_variables.UserCredentials;


public class AddingCollegeWIthInvalidDataTestCase implements UserCredentials{
	WebDriver driver;
	CollegesInMDM collegePage;
	
	@Test
	public void setup()
	{
		driver = BrowserFactory.getDriver(DriverType.CHROME);
//		collegePage = new SignUpPage(driver).signup(username, password).signIn(username, password).clickOnToggleButton()
//				.clickMasterDataManagementLink().clickOnColleges();
//			
		collegePage = new CollegesInMDM(driver).getCollegesPage();
	}
	
	@Test( dataProvider = "invalidCollegeData", dataProviderClass = DataProviderSource.class, dependsOnMethods = "setup")
	public void addingACollege(College college) {
		AddCollegeModal addCollegeModal = collegePage.clickOnAddCollege();
		addCollegeModal.addCollegeDetails(college);
		Assert.assertFalse(addCollegeModal.isSaveButtonEnabled());
		addCollegeModal.clickCancel(); //executes this statement when the save button is disabled
		
	}
	@Test(dependsOnMethods="addingACollege")
	public void tearDown()
	{
		driver.close();
	}
}
