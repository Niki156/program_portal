package com.epam.CalculatorDemo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class isPositiveTestCases extends Setup {
	@DataProvider(name = "AllNegativeData")
	public Object[][] sendAllNegativeData()
	{
		
		return new Object[][] {
			{-1, false},
			{Long.MIN_VALUE-1, true},
			{(long)-200, false},
			{Long.MIN_VALUE, false},
			{Long.MIN_VALUE+1, false}
		};
	}
	@DataProvider(name="AllPositiveData")
	public Object[][] sendAllPositiveData()
	{
		return new Object[][] {
			{1, true},
			{(long)100, true},
			{Long.MAX_VALUE, true},
			{Long.MAX_VALUE+1, false},
			{Long.MAX_VALUE-1, true}
		};
	}
	
	@Test
	public void passingZeroTestCase()
	{
		Assert.assertEquals(calculatorObject.isPositive(0), false);
	}
	
	@Test(dataProvider = "AllNegativeData")
	public void isNegativeTestcases(long number, boolean expectedValue)
	{
		Assert.assertEquals(calculatorObject.isPositive(number), expectedValue);
	}
	@Test(dataProvider = "AllPositiveData")
	public void isPositiveTestcases(long number, boolean expectedValue)
	{
		Assert.assertEquals(calculatorObject.isPositive(number), expectedValue);
	}
	
}
