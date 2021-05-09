package com.epam.framework.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.epam.framework.browser_functions.BrowserReusableFunctions;

public class TestListener implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			BrowserReusableFunctions.takeScreenShot((WebDriver)result.getTestContext().getAttribute("driver"), result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
