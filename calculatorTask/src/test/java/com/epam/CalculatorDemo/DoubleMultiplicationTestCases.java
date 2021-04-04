package com.epam.CalculatorDemo;

import org.testng.Assert;
import org.testng.annotations.*;

import com.epam.tat.module4.Calculator;


/**
 * Unit test for simple App.
 */
@SuppressWarnings("unused")
public class DoubleMultiplicationTestCases extends Setup
{
    /**
     * Rigorous Test :-)
     */
	@DataProvider(name = "NormalDoubleData")
	public Object[][] sendDoubleData()
	{
		return new Object[][] {
			{0.0,1.0, 0.0},
			{0.0,0.0,0.0},
			{1.5, 2.0, 3.0},
			{2.5,2.0,5.0},
			{2.5,-2.0,-5.0},
			{-2.5,2.0,-5.0},
			{5, 106.6, 533},
			{957.48, 600 , 574488}
			
		};
	}
	@DataProvider(name = "BoundaryDoubleData")
	public Object[][] sendBoundaryDoubleData()
	{
		return new Object[][] {
			
			{Double.MAX_VALUE,1, Double.MAX_VALUE},
			{Double.MIN_VALUE, 1, 0.0}, // doubt
			{Double.MIN_VALUE, Double.MIN_VALUE, 0},
			{Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY}
		};
	}
	
	@Test(dataProvider = "NormalDoubleData")
	public void multiplyTwoDouble(double firstNumber, double secondNumber, double expectedAnswer)
	{
		Assert.assertEquals(calculatorObject.mult(firstNumber, secondNumber), expectedAnswer);
	}
	@Test(dataProvider="BoundaryDoubleData")
	public void multiplyTwoDoubleAtBoundaryTestCases(double firstNumber, double secondNumber, double expectedAnswer)
	{
		Assert.assertEquals(calculatorObject.mult(firstNumber, secondNumber), expectedAnswer);
	}
	

	
	
}
