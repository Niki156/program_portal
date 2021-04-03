package com.epam.engx.cleancode.dry.task1;

import com.epam.engx.cleancode.dry.task1.thirdpartyjar.Profitable;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InterestCalculator implements Profitable {

    private static final int AGE = 60;
    private static final double INTEREST_PERCENT = 4.5d;
    private static final double SENIOR_PERCENT = 5.5d;
    private static final int BONUS_AGE = 13;
    private static final int LEAP_YEAR_SHIFT = 1;

    public BigDecimal calculateInterest(AccountDetails accountDetails) {
    	double interest=0;
        if (isAccountStartedAfterBonusAge(accountDetails)) {
        	double tempValue = accountDetails.getBalance().doubleValue() * durationBetweenDatesInYears(accountDetails.getStartDate(), new Date());
        	if (AGE <= accountDetails.getAge()) {
                //interest = (PrincipalAmount * DurationInYears * AnnualInterestRate) / 100
                interest = tempValue * SENIOR_PERCENT / 100;
            } else {
                interest = tempValue * INTEREST_PERCENT / 100;
            }
        }
        	return BigDecimal.valueOf(interest);
    }

    private boolean isAccountStartedAfterBonusAge(AccountDetails accountDetails) {
        return durationBetweenDatesInYears(accountDetails.getBirth(), accountDetails.getStartDate()) > BONUS_AGE;
    }

    private int durationBetweenDatesInYears(Date from, Date to) {
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(from);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(to);

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        if (endCalendar.get(Calendar.DAY_OF_YEAR) + LEAP_YEAR_SHIFT < startCalendar.get(Calendar.DAY_OF_YEAR))
            return diffYear - 1;
        return diffYear;
    }
  
}
