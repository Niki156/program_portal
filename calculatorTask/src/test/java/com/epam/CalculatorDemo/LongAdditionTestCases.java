package com.epam.CalculatorDemo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LongAdditionTestCases extends Setup{
	@DataProvider(name="LongAdditionData")
	public Object[][] sendNormalAdditionData()
	{
		return new Object[][] {
			{12345, 345678, 358023},
			{989898, 10102, 1000000},
			{Long.MIN_VALUE, 0, Long.MIN_VALUE},
			{Long.MAX_VALUE, 0, Long.MAX_VALUE},
			{Long.MIN_VALUE, Long.MAX_VALUE, -1},
			{10000, 10000, 20000},
			{-1234, -1234, -2468}
		};
	}
	@Test(dataProvider="LongAdditionData")
	public void testLongDataAddition(long firstNumber, long secondNumber, long expectedResult)
	{
		Assert.assertEquals(calculatorObject.sum(firstNumber, secondNumber), expectedResult);
	}

}
