package com.epam.framework.browser_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.program_portal.constants.DriverConstants;

public class BrowserFactory {
	private BrowserFactory() {
	}

	public static WebDriver getDriver(DriverType browserType) {
		WebDriver driver;
		switch (browserType) {
		case CHROME:
			System.setProperty(DriverConstants.CHROME_DRIVER_PROPERTY, DriverConstants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty(DriverConstants.FIREFOX_DRIVER_PROPERTY, DriverConstants.FIREFOX_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		case EDGE:
			System.setProperty(DriverConstants.EDGE_DRIVER_PROPERTY, DriverConstants.EDGE_DRIVER_PATH);
			driver = new EdgeDriver();
			break;
		default:
			driver = new ChromeDriver();
		}
		return driver;
	}
}
