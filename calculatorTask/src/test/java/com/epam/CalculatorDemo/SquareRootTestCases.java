package com.epam.CalculatorDemo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SquareRootTestCases extends Setup{
	@DataProvider(name="squareRootData")
	public Object[][] sendSquareRootData()
	{
		return new Object[][] {
			{0,0},
			{1,1},
			{4,2},
			{81, 9},
			{6.25, 2.5},
			{0.01, 0.1},
			{0.0152399025, 0.12345},
			{533, 23.08679276123039},
			{1524155677489d, 1234567},
			{912.04, 30.2},
			{9223372036854775807d, }
		};
	}
	@Test(dataProvider="squareRootData")
	public void testSquareRootFunction(double value, double expectedValue)
	{
		Assert.assertEquals(calculatorObject.sqrt(value), expectedValue);
	}

}
