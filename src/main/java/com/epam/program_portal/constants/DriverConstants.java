package com.epam.program_portal.constants;

public class DriverConstants {
	private DriverConstants()
	{}
	public static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	public static final String CHROME_DRIVER_PATH = "src\\main\\resources\\drivers\\chromedriver.exe";

	
	public static final String EDGE_DRIVER_PROPERTY = "webdriver.edge.driver";
	public static final String EDGE_DRIVER_PATH = "src\\main\\resources\\drivers\\msedgedriver.exe";
	
	public static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	public static final String FIREFOX_DRIVER_PATH = "src\\main\\resources\\drivers\\geckodriver.exe";
	
	
	public static final int DEFAULT_WAIT_TIME = 10;
}
