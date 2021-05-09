package com.epam.program_portal.utility_functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.epam.framework.logger_functions.LoggerReusableFunctions;
import com.epam.program_portal.api.beans.College;
import com.epam.program_portal.constants.JDBC_Constants;

public class JDBCUtilityFunctions {
	private static FileInputStream file;
	private static Properties jdbcUserConfig;
	private static Connection connection;
	
	private JDBCUtilityFunctions() {}

	public static void setup() {
		try {
			file = new FileInputStream(new File(JDBC_Constants.configPath));
			jdbcUserConfig = new Properties();
			jdbcUserConfig.load(file);
		} catch (IOException exception) {
			LoggerReusableFunctions.logError("IO Exception while reading the file. "+exception.getStackTrace());
		}

	}

	public static void getConnection() {
		setup();
		String username = jdbcUserConfig.getProperty("username");
		String password = jdbcUserConfig.getProperty("password");
		String schema = jdbcUserConfig.getProperty("schema");
		String hostLink = jdbcUserConfig.getProperty("host_link");
		try {
			connection = DriverManager.getConnection( hostLink + schema, username, password);

			Class.forName(jdbcUserConfig.getProperty("jdbc_driver_class"));
		} catch (SQLException e) {
			LoggerReusableFunctions.logError("SQL exception for Connection Object. check internet or VPN");
		} catch (ClassNotFoundException e) {
			LoggerReusableFunctions.logError("Class not found exception for JDBC Driver class. "+e.getStackTrace());
		}
	}


	public static PreparedStatement getPreparedStatementForFetchingCountOfColleges(College college)
	{
		getConnection();
		PreparedStatement statement=null;
		try {
			statement = connection.prepareStatement("select count(*) from colleges where name=? and city=? and colleges.group=? and pto_name=? and pto_email=?");
			statement.setString(1, college.getCollegeName());
			statement.setString(2, college.getCity());
			statement.setString(3, college.getGroup());
			statement.setString(4, college.getPtoName());
			statement.setString(5, college.getPtoEmail());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(statement==null)
			LoggerReusableFunctions.logWarn("statement generated to prepare college has failed");
		return statement;
		
	}
	public static boolean checkIfCollegeAddedInDB(College college)
	{
		getConnection();
		PreparedStatement statement = getPreparedStatementForFetchingCountOfColleges(college);
		try {
			ResultSet results =statement.executeQuery();
			results.next();
			if(results.getInt("count(*)")>=1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static List<String> getIdsOfActiveColleges(int limit) throws SQLException
	{
		getConnection();
		List<String> idList = new ArrayList<String>();
		PreparedStatement statement = connection.prepareStatement("select id from colleges where colleges.status='ACTIVE' limit ?;");
		statement.setInt(1, limit);
		ResultSet results  = statement.executeQuery();
		while(results.next())
		{
			idList.add(results.getString("id"));
		}
		return idList;
	}
	

	
}
