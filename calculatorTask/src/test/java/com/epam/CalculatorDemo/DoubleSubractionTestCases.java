package com.epam.CalculatorDemo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoubleSubractionTestCases extends Setup {
	@DataProvider(name="NormalData")
	public Object[][] sendNormalData()
	{
		return new Object[][] {
			{1000, 0.75, 999.25},
			{1999d, -1d, 2000d},
		//	{1.12345678, 0.12345678, 1d}
			{1.12345, 0.12345, 1},
			{123.456, 0.456, 123},
			{100d, 100.5, -0.5}
			
		};
	}
	@DataProvider(name="BoundaryData")
	public Object[][] sendBoundaryData()
	{
		return new Object[][] {
			{Double.MIN_VALUE, Double.MIN_VALUE, 0},
			{Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY}, //doubt
			{Double.MAX_VALUE, -Double.MIN_VALUE, -1},
			{Double.MIN_VALUE, -Double.MAX_VALUE, -1},
			{-Double.MIN_VALUE, -Double.MAX_VALUE,0}
		};
	}
	
	@Test(dataProvider="NormalData")
	public void testSubractionWithNormalData(double firstNumber, double secondNumber, double expectedResult)
	{
		Assert.assertEquals(calculatorObject.sub(firstNumber, secondNumber), expectedResult);
	}
	@Test(dataProvider="BoundaryData")
	public void testSubractionWithBoundaryData(double firstNumber, double secondNumber, double expectedResult)
	{
		Assert.assertEquals(calculatorObject.mult(firstNumber, secondNumber), expectedResult);
	}

}
