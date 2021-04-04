package com.epam.CalculatorDemo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LongMultiplicationTestCase extends Setup{

	@DataProvider(name = "NormalLongData")
	public Object[][] sendDoubleData()
	{
		return new Object[][] {
			{2l,3l,6l},
			{1234567890l, 10l, 12345678900l},
			{12345678900l, 10l, 123456789000l},
			{123456789000l, 10l, 1234567890000l},
			
			
		};
	}
	@DataProvider(name = "BoundaryLongData")
	public Object[][] sendBoundaryDoubleData()
	{
		return new Object[][] {
			
			{Long.MAX_VALUE,1, Long.MAX_VALUE},
			{Long.MIN_VALUE, 1, Long.MIN_VALUE}, 
			{Long.MIN_VALUE, Long.MIN_VALUE, 0},
			{Long.MAX_VALUE, Long.MAX_VALUE, 1} // doubt
		};
	}
	
	@Test(dataProvider = "NormalLongData")
	public void testNormalData(long first, long second, long expectedResult)
	{
		Assert.assertEquals(calculatorObject.mult(first, second), expectedResult);
	}
	
	@Test(dataProvider="BoundaryLongData")
	public void testBoundaryData(long first, long second, long expectedResult)
	{
		Assert.assertEquals(calculatorObject.mult(first, second), expectedResult);
	}
}
