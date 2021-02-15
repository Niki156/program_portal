package com.epam.engx.cleancode.naming.task3;

public class HarshadNumber {
	public String main() {
		StringBuilder result = new StringBuilder();
		int limit = 200; // limit the seq of Harshad numbers
		for (int number = 1; number <= limit; number++) {
			if (number % getSumOfDigits(number) == 0) {
				result.append(number).append("\n");
			}
		}
		return result.toString();
	}

	private int getSumOfDigits(int number) {
		int sumOfDigits = 0;
		while (number != 0) {
            sumOfDigits += number % 10;
            number = number / 10;
        }
		return sumOfDigits;
	}

}
