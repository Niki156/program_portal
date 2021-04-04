package com.epam.CalculatorDemo;
import org.testng.annotations.BeforeMethod;
import com.epam.tat.module4.Calculator;

public class Setup {
	protected Calculator calculatorObject;
	
	@BeforeMethod
	public void setup()
	{
		calculatorObject = new Calculator();
	}
}
