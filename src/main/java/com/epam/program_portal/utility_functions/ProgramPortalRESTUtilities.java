package com.epam.program_portal.utility_functions;


import org.json.JSONObject;

import com.epam.program_portal.api.beans.College;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProgramPortalRESTUtilities {
	public static Response getResponseWithID(RequestSpecification httprequest, String id)
	{
		 httprequest.header("content-type", "application/json");
		 return httprequest.get("colleges/"+id);
	}
	public static Response getResponseByPostingJSONCollege(RequestSpecification httprequest, JSONObject collegeJSONObject )
	{

		httprequest.header("content-type", "application/json");
		httprequest.body(collegeJSONObject.toString());
		return httprequest.post("colleges");
	}
	public static College getCollegePOJOFromResponse(Response response)
	{
		return new Gson().fromJson(response.asString(), College.class);
	}
	public static Response updateCollege(RequestSpecification httprequest, College college, String id) {
		college.setCollegeId(id);
		college.setStatus("ACTIVE");
		httprequest.header("content-type", "application/json");
		httprequest.body(new Gson().toJson(college).toString());
		return httprequest.put("colleges/"+id);	
	}
	public static Response deleteCollegeByID(RequestSpecification httprequest, String id)
	{
		return httprequest.delete("colleges/"+id);
	}
}
