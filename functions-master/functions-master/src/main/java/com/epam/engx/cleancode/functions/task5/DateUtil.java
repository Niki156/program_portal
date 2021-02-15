package com.epam.engx.cleancode.functions.task5;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private int defaultValue=0;
	private int addOne()
	{
		return 1;
	}
	private int minusOne()
	{
		return -1;
	}
	private void changeTime(Calendar calendar)
	{
		calendar.set(Calendar.HOUR_OF_DAY,defaultValue );
		calendar.set(Calendar.MINUTE, defaultValue);
		calendar.set(Calendar.SECOND, defaultValue);
		calendar.set(Calendar.MILLISECOND, defaultValue);
	}

	public Date changeToMidnight(Date date, boolean up) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, up ? addOne(): minusOne());
		changeTime(calendar);
		return calendar.getTime();
	}

}
