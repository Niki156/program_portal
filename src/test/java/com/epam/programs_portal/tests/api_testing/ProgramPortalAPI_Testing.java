package com.epam.programs_portal.tests.api_testing;

import static org.testng.Assert.assertEquals;

import java.sql.SQLException;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.epam.program_portal.api.beans.College;
import com.epam.program_portal.utility_functions.JSONUtilities;
import com.epam.program_portal.utility_functions.ProgramPortalRESTUtilities;
import com.epam.programs_portal.data_provider.DataProviderSource;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProgramPortalAPI_Testing {
	RequestSpecification httprequest;
	@Test
	public void setup()
	{
		RestAssured.baseURI = "http://epinhydw0087:9090/programs/";
		httprequest = RestAssured.given();
	}
	@Test(dataProvider = "college", dataProviderClass = DataProviderSource.class, dependsOnMethods="setup")
	public void addCollege(College college) {
		SoftAssert softassert = new SoftAssert();
		JSONObject collegeJSONObject = JSONUtilities.getJSONFromCollegeObject(college);
		Response response = ProgramPortalRESTUtilities.getResponseByPostingJSONCollege(httprequest, collegeJSONObject);
		College collegeAdded = ProgramPortalRESTUtilities.getCollegePOJOFromResponse(response);
		softassert.assertEquals(response.getStatusCode(), 201);
		softassert.assertTrue(College.isTwoCollegesEqual(college, collegeAdded));
		softassert.assertAll();
	}

	@Test(dataProvider = "sendIdOfActiveColleges", dataProviderClass = DataProviderSource.class, dependsOnMethods="setup")
	public void editCollegeByID(String id, College updatedCollege) {
		Response updatedResponse = ProgramPortalRESTUtilities.updateCollege(httprequest, updatedCollege, id);
		College updatedCollegeInDB = ProgramPortalRESTUtilities.getCollegePOJOFromResponse(updatedResponse);
		Assert.assertTrue(College.isTwoCollegesEqual(updatedCollege, updatedCollegeInDB));
	}

	@Test(dataProvider = "sendIdOfActiveCollegesToDeleteFromExcel", dataProviderClass = DataProviderSource.class, dependsOnMethods="setup")
	public void deleteCollegeByID(String id) {
		Response response = ProgramPortalRESTUtilities.deleteCollegeByID(httprequest, id);
		College college = ProgramPortalRESTUtilities.getCollegePOJOFromResponse(response);
		assertEquals(college.getStatus(), "DISABLED");
	}

	@Test(dataProvider = "sendIdOfActiveCollegesToDeleteFromJDBC", dataProviderClass = DataProviderSource.class, dependsOnMethods="setup")
	public void deleteCollegesById(String id) throws SQLException // get active colleges from jdbc
	{
		Response response = ProgramPortalRESTUtilities.deleteCollegeByID(httprequest, id);
		College college = ProgramPortalRESTUtilities.getCollegePOJOFromResponse(response);
		assertEquals(college.getStatus(), "DISABLED");
	}
	

}
