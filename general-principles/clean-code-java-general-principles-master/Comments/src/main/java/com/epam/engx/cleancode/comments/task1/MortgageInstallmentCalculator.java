package com.epam.engx.cleancode.comments.task1;

import com.epam.engx.cleancode.comments.task1.thirdpartyjar.InvalidInputException;

public class MortgageInstallmentCalculator {

    /**
     * @return monthly payment amount
     */
	//checks and returns true if the integer variables are negative, else returns false
	private static boolean isNegative(int value)
	{
		return value<0?true:false;
	}
	// checks and returns true if the double variables are negative, else returns false
	private static boolean isNegative(double value)
	{
		return value<0?true:false;
	}
    public static double calculateMonthlyPayment(
            int principalAmount, int mortgageDurationInYears, double rateOfIntrest) {

         if (isNegative(principalAmount) || isNegative(mortgageDurationInYears)|| isNegative(rateOfIntrest)) {
            throw new InvalidInputException("Negative values are not allowed");
        }

        double rateOfIntrestInDecimal = rateOfIntrest/100.0;  
        double monthlyRate = rateOfIntrestInDecimal / 12.0;  // dividing RateOfIntrest by 12 to get monthly rate. 12 stands for number of months in a year
        

        double termInMonths = mortgageDurationInYears * 12;
        
        //for zero interest rates
        if(rateOfIntrest==0)
            return  principalAmount/termInMonths;

        else {
        // returning the monthly payment
        // The Math.pow() method is used calculate values raised to a power
        return (principalAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termInMonths));
        }

    }
}
