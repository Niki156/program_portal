package com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar;

public class NullException extends Exception{
	String message;
	public NullException(String msg)
	{
		message = msg;
	}
	public String toString()
	{
		return message;
	}
}
