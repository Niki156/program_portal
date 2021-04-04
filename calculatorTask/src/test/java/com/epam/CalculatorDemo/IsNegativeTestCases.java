package com.epam.CalculatorDemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

public class IsNegativeTestCases extends Setup {
	
	@DataProvider(name = "AllNegativeData")
	public Object[][] sendAllNegativeData()
	{
		
		return new Object[][] {
			{-1, true},
			{Long.MIN_VALUE-1, false},
			{(long)-200, true},
			{Long.MIN_VALUE, true},
			{Long.MIN_VALUE+1, true}
		};
	}
	@DataProvider(name="AllPositiveData")
	public Object[][] sendAllPositiveData()
	{
		return new Object[][] {
			{1, false},
			{(long)100, false},
			{Long.MAX_VALUE, false},
			{Long.MAX_VALUE+1, true},
			{Long.MAX_VALUE-1, false}
		};
	}
	
	@Test
	public void passingZeroTestCase()
	{
		Assert.assertEquals(calculatorObject.isNegative(0), false);
	}
	
	@Test(dataProvider = "AllNegativeData")
	public void isNegativeTestcases(long number, boolean bool)
	{
		Assert.assertEquals(calculatorObject.isNegative(number), bool);
	}
	@Test(dataProvider = "AllPositiveData")
	public void isPositiveTestcases(long number, boolean bool)
	{
		Assert.assertEquals(calculatorObject.isNegative(number), bool);
	}
	
}
