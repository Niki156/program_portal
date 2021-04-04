package com.epam.CalculatorDemo;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoubleDivisionTestCase extends Setup {
	
	
	@DataProvider(name = "NormalPositiveDoubleData")
	public Object[][] sendNormalPositiveDoubleData()
	{
		return new Object[][] {
			{0.0,1.0, 0.0},
			{1.5, 2.0, 0.75},
			{5d,2d,2.5},
			{9.0,3.0,3.0}
		};
	}
	@DataProvider(name = "NormalNegativeDoubleData")
	public Object[][] sendNormalNegativeDoubleData()
	{
		return new Object[][] {
			{5,-2.0,-2.5},
			{-5, 2, -2.5},
			{-1000, -2, 500}
		};
	}
	@DataProvider(name = "BoundaryDoubleData")
	public Object[][] sendBoundaryDoubleData()
	{
		return new Object[][] {
			
			{Double.MAX_VALUE,1, Double.MAX_VALUE},
			{Double.MIN_VALUE, 1, Double.MIN_VALUE}, 
			{Double.MIN_VALUE, Double.MIN_VALUE, 1d},
			{Double.MAX_VALUE, Double.MAX_VALUE, 1d}
		};
	}
	
	
	@Test(dataProvider = "NormalPositiveDoubleData")
	public void normalPositiveDoubleDataDivisionTest(double firstNumber, double secondNumber, double expectedAnswer)
	{
		Assert.assertEquals(calculatorObject.div(firstNumber, secondNumber), expectedAnswer);
	}
	
	@Test(dataProvider= "NormalNegativeDoubleData")
	public void normalNegativeDoubleDataDivisionTest(double firstNumber, double secondNumber, double expectedAnswer)
	{
		Assert.assertEquals(calculatorObject.div(firstNumber, secondNumber), expectedAnswer);
	}
	@Test(dataProvider="BoundaryDoubleData")
	public void boundaryDoubleDataDivisionTest(double firstNumber, double secondNumber, double expectedAnswer)
	{
		Assert.assertEquals(calculatorObject.div(firstNumber, secondNumber), expectedAnswer);
	}
	
	
}
