package com.epam.program_portal.utility_functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.epam.framework.logger_functions.LoggerReusableFunctions;

public class UserPropertiesUtilities {
	private UserPropertiesUtilities() {}
	
	private static String username =null;
	private static String password = null;
	
	public static String getUsername() {
		if(username==null)
			new UserPropertiesUtilities().setup();
		return username;
	}
	public static String getPassword() {
		if(password==null)
			new UserPropertiesUtilities().setup();
		return password;
	}

	
	private void setup()
	{
		try {
			FileInputStream fileStream = new FileInputStream(new File("src/main/resources/user_credentials/user.properties"));
			Properties userProperties = new Properties();
			userProperties.load(fileStream);
			username = userProperties.getProperty("username", "asdf@gmail.com");
			password = userProperties.getProperty("password", "asdfasdf");
			
		} catch (FileNotFoundException e) {
			LoggerReusableFunctions.logError("User Credentials File not Found in src/main/resources/User_credentials path");
			
		}
		catch (IOException e) {
			LoggerReusableFunctions.logError("Error occured while reading the properties file");
		}
		
	}

}
