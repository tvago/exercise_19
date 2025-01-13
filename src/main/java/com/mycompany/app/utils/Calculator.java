package com.mycompany.app.utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Calculator {

	/**
	 * Checks if the given dividend is divisible by the specified divisor without a remainder.
	 *
	 * @param dividend the number to be divided.
	 * @param divisor the number by which the dividend is divided.
	 * @return true if the dividend is divisible by the divisor (remainder is 0), false otherwise.
	 * @throws ArithmeticException if the divisor is 0, as division by zero is undefined.
	 */
	public boolean isDivisibleBy(int dividend, int divisor){
		return dividend % divisor == 0;
	}

}
