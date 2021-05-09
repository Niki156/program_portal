package com.epam.programs_portal.data_provider;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.epam.program_portal.api.beans.College;
import com.epam.program_portal.utility_functions.ExcelUtilityFunctions;
import com.epam.program_portal.utility_functions.JDBCUtilityFunctions;


public class DataProviderSource {
	
	@DataProvider(name = "sendDataForSearchBox")
	public Object[][] sendDataForSearchBox() throws IOException {
		return ExcelUtilityFunctions.sendSearchDataForSearchBoxInCollegePage();
	}
	@DataProvider(name = "credentialsForSignUpandSignIn")
	public Object[][] sendCredentialsForSignUp() throws IOException {
		return ExcelUtilityFunctions.sendUserNamesAndPassWordFromExcel();
	}
	@DataProvider(name = "validCollegeData")
	public Object[][] sendValidCollegeData() throws IOException {
		return ExcelUtilityFunctions.sendCollegeDataForAddingACollege();
	}
	@DataProvider(name = "invalidCollegeData")
	public Object[][] sendInvalidCollegeData() throws IOException {
		return ExcelUtilityFunctions.sendInvalidDataForAddingCollege();
	}
	
	@DataProvider(name="sendIdOfActiveColleges")
	public Object[][] sendIdsOfActiveColleges() throws IOException
	{
		return ExcelUtilityFunctions.sendCollegeIDOfActiveColleges();
	}
	@DataProvider(name = "sendIdOfActiveCollegesToDeleteFromExcel")
	public Object[][] sendIdsOfActiveCollegesToDelete() throws IOException
	{
		return ExcelUtilityFunctions.sendCollegeIdOfActiveCollegesForDeleting();
	}
	@DataProvider(name = "sendIdOfActiveCollegesToDeleteFromJDBC")
	public Object[][] sendIdsOfActiveCollegesToDeleteFromJDBC() throws SQLException
	{
		List<String> idList = JDBCUtilityFunctions.getIdsOfActiveColleges(4);
		int size = idList.size();
		Object[][] idObject = new Object[size][1];
		int index = 0;
		for(String id: idList)
		{
			idObject[index++][0] = id;
		}
		return idObject;
		
	}
	@DataProvider(name="college")
	public Object[][] send()
	{
		College college = new College();
		college.setCity("kurnool");
		college.setPtoName("group name");
		college.setCollegeName("nikhil college");
		college.setPtoEmail("nikhil@xyz.com");
		college.setGroup("nikhil group of industries");
		return new Object[][] {
			{college}, {college}, {college}, {college}
		};
		
	}
	
}
