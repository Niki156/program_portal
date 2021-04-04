package com.epam.CalculatorDemo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LongSubractionTestCases extends Setup{

	@DataProvider(name="NormalLongSubractionData")
	public Object[][] sendNormalLongSubractionData()
	{
		return new Object[][] {
			{1000l, 500l, 500l},
			{500l, 1000l, -500l},
			{10000l, 0l, 10000l},
			{0l, 1000l, -1000l}
		};
	}
	@DataProvider(name="BoundaryLongSubractionData")
	public Object[][] sendBOundaryLongSubractionData()
	{
		return new Object[][] {
			{Long.MAX_VALUE, Long.MAX_VALUE, 0},
			{Long.MIN_VALUE, Long.MIN_VALUE, 0}, 
			{Long.MIN_VALUE, -Long.MIN_VALUE, 0},
			{Long.MAX_VALUE, Long.MIN_VALUE, -1},
			{Long.MIN_VALUE, Long.MAX_VALUE, 1}
		};
	}
	@Test(dataProvider="BoundaryLongSubractionData")
	public void testSubractionForBoundaryLongData(long firstNumber, long secondNumber, long expectedAnswer)
	{
		Assert.assertEquals(calculatorObject.sub(firstNumber, secondNumber), expectedAnswer);
	}
	@Test(dataProvider="NormalLongSubractionData")
	public void testSubractionForNormalLongData(long firstNumber, long secondNumber, long expectedAnswer)
	{
		Assert.assertEquals(calculatorObject.sub(firstNumber, secondNumber), expectedAnswer);
	}
	
	
}
