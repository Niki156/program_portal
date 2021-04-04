package com.epam.CalculatorDemo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoubleAdditionTestCases extends Setup{
	@DataProvider(name="NormalAdditionData")
	public Object[][] sendNormalAdditionData()
	{
		return new Object[][] {
			{12345.678, 456.456, 12802.134},
			{147.56, 369.55, 517.11},
			{1000, 533.533, 1533.533}
		};
	}
	@DataProvider(name="BoundaryAdditionData")
	public Object[][] sendBoundaryAdditionData()
	{
		return new Object[][] {
			{Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY},
			{Double.MIN_VALUE, -Double.MIN_VALUE, 0},
			{Double.MAX_VALUE, 0, Double.MAX_VALUE},
			{Double.MIN_VALUE, 0, Double.MIN_VALUE},
			{-Double.MAX_VALUE, Double.MAX_VALUE, 0}
		};
	}
	@Test(dataProvider="BoundaryAdditionData")
	public void testAdditionForBoundaryData(double firstNumber, double secondNumber, double expectedValue)
	{
		Assert.assertEquals(calculatorObject.sum(firstNumber, secondNumber), expectedValue);
	}
	
	@Test(dataProvider="NormalAdditionData")
	public void testAdditionForNormalData(double firstNumber, double secondNumber, double expectedValue)
	{
		Assert.assertEquals(calculatorObject.sum(firstNumber, secondNumber), expectedValue);
	}
}
