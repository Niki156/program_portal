package com.epam.program_portal.utility_functions;

import org.json.JSONObject;

import com.epam.program_portal.api.beans.College;

public class JSONUtilities {
	public static JSONObject getJSONFromCollegeObject(College college)
	{
		JSONObject requestBody = new JSONObject();
		requestBody.put("city", college.getCity());
		requestBody.put("collegeName", college.getCollegeName());
		requestBody.put("group"	, college.getGroup());
		requestBody.put("ptoName", college.getPtoName());
		requestBody.put("ptoEmail"	, college.getPtoEmail());
		return requestBody;
	}
}
