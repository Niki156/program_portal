package com.epam.CalculatorDemo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowerFunctionTestCases extends Setup{
	@DataProvider(name="NormalExponentData")
	public Object[][] sendExponentData()
	{
		return new Object[][] {
			{2d,2d,4d},
			{2.5d, 2d, 6.25d},
			{3d, 2d, 9d},
			{9394.4d, 0, 1d},
			{133.56, 2, 17838.2736},
			 //{0.1, 3, 0.001d},
			 {0, 12345678d, 0}
		};
	}
	
	@DataProvider(name="BoundaryExponentData")
	public Object[][] sendBoundaryData()
	{
		return new Object[][] {
			{Double.MAX_VALUE, 0, 1},
			{Double.MIN_VALUE, 0, 1},
			{Double.MAX_VALUE, 1, Double.MAX_VALUE},
			{Double.MIN_VALUE, 1, Double.MIN_VALUE},
			{Double.MAX_VALUE, 10, Double.POSITIVE_INFINITY},
			{Double.MAX_VALUE, 2, Double.POSITIVE_INFINITY},
			{Double.MIN_VALUE, 10, 0d}
		};
	}
	@Test(dataProvider="NormalExponentData")
	public void testPowerAtNormalValues(double base, double exponent, double expectedResult)
	{
		Assert.assertEquals(calculatorObject.pow(base, exponent), expectedResult);
	}
	@Test(dataProvider="BoundaryExponentData")
	public void testPowerAtBoundaryValues(double base, double exponent, double expectedResult)
	{
		Assert.assertEquals(calculatorObject.pow(base, exponent), expectedResult);
	}
	
	
	
}
