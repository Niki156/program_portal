package com.epam.CalculatorDemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
public class LongDivisionTestCases extends Setup {
	@DataProvider(name="PositiveDivisionData")
	public Object[][] sendPositiveDivisionData() {
		return new Object[][] {
			{(long)5,(long)2,(long)2},
			{Long.MAX_VALUE, 1, Long.MAX_VALUE},
			{Long.MAX_VALUE, Long.MAX_VALUE, 1},
			{(long)10000, (long)2, (long)5000},
			
		};
	}
	@DataProvider(name="NegativeDivisionData")
	public Object[][] sendNegativeDivisionData()
	{
		return new Object[][] {
			{Long.MIN_VALUE, 1, Long.MIN_VALUE},
			{Long.MIN_VALUE, -1, -1*Long.MIN_VALUE},
			{Long.MAX_VALUE, -1, -1*Long.MAX_VALUE}
		};
	}
	@DataProvider(name="DataWithDenominatorZeroes")
	public Object[][] sendDataWithZeroes()
	{
		return new Object[][] {
			{Long.MAX_VALUE, 0},
			{Long.MIN_VALUE, 0},
			{1000, 0},
		};
	}
	
	@Test(dataProvider="PositiveDivisionData")
	public void longPositiveDivisionTest(long numerator, long denominator, long expected)
	{
			Assert.assertEquals(calculatorObject.div(numerator, denominator), expected);
	}
	
	@Test(dataProvider="NegativeDivisionData")
	public void longNegativeDivisionTest(long numerator, long denominator, long expected)
	{
		Assert.assertEquals(calculatorObject.div(numerator, denominator), expected);
	}
	
	@Test(dataProvider="DataWithDenominatorZeroes", expectedExceptions = NumberFormatException.class)
	public void longZeroDivisionTest(long numerator, long demoninator)
	{
		calculatorObject.div(numerator, demoninator);
	}
	
	
	
}
