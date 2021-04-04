package com.epam.CalculatorDemo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TrignometricMethodsTestcases extends Setup{
	@DataProvider(name="CosineData")
	public Object[][] sendCosineData()
	{
		return new Object[][] {
			//{0, 1},
			//{30*Math.PI/180, Math.sqrt(3)/2},
			{45*Math.PI/180, 1/Math.sqrt(2)},
			{225*Math.PI/180, -1/Math.sqrt(2)},
			
			//{60*Math.PI/180, 0.5d},
			//{90*Math.PI/180, 0}
		};
	}
	@DataProvider(name="SineData")
	public Object[][] sendSineData()
	{
		return new Object[][] {
			{0, 0},
			//{30*Math.PI/180, 0.5d},
			{45*Math.PI/180, 1/Math.sqrt(2)},
			{60*Math.PI/180, Math.sqrt(3)/2},
			{90*Math.PI/180, 1},
			//{180*Math.PI/180, 0},
			//{360*Math.PI/180, 0},
			{270*Math.PI/180, -1},
			{225*Math.PI/180, -1/Math.sqrt(2)},
			//{-30*Math.PI/180, -0.5}
		};
	}
	@DataProvider(name="TangentData")
	public Object[][] sendTangentData()
	{
		return new Object[][] {
			//{0,0},
			{45*Math.PI/180, 1},
			//{30*Math.PI/180, 1/Math.sqrt(3)},
			//{60*Math.PI/180, Math.sqrt(3)},
			//{225*Math.PI/180, 1},
			//{315*Math.PI/180, -1}
		};
	}
	@DataProvider(name="CotangentData")
	public Object[][] sendCotangentData()
	{
		return new Object[][] {
			{30*Math.PI/180,Math.sqrt(3)},
			{45*Math.PI/180, 1},
			{60*Math.PI/180, 1/Math.sqrt(3)},
			{90*Math.PI/180, 0},
			
		};
	}
	
	@Test(dataProvider="SineData")
	public void testSineFunction(double angle, double expectedValue)
	{
		Assert.assertEquals(calculatorObject.sin(angle), expectedValue);
	}
	
	@Test(dataProvider="CosineData")
	public void testCosineFunction(double angle, double expectedValue)
	{
		Assert.assertEquals(calculatorObject.cos(angle), expectedValue);
	}
	@Test(dataProvider="TangentData")
	public void testTangentFunction(double angle, double expectedValue)
	{
		Assert.assertEquals(calculatorObject.tg(angle), expectedValue);
	}
	@Test(dataProvider="CotangentData")
	public void testCotangentFunction(double angle, double expectedValue)
	{
		Assert.assertEquals(calculatorObject.ctg(angle), expectedValue);
	}
}
