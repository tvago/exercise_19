package com.mycompany.app.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
	Calculator calculator;

	@BeforeEach
	void initialize(){
		calculator = new Calculator();
	}

	@Test
	void testIsDevidedBy_TrueCase() {

		// Positive test cases
		assertTrue(calculator.isDivisibleBy(10, 2), "10 should be divisible by 2");
		assertTrue(calculator.isDivisibleBy(15, 5), "15 should be divisible by 5");
		assertTrue(calculator.isDivisibleBy(0, 1), "0 is divisible by any non-zero number");
	}

	@Test
	void testIsDevidedBy_FalseCase() {

		// Negative test cases
		assertFalse(calculator.isDivisibleBy(10, 3), "10 is not divisible by 3");
		assertFalse(calculator.isDivisibleBy(7, 2), "7 is not divisible by 2");
	}

	@Test
	void testIsDevidedBy_DivisionByZero() {
		// Test division by zero
		Exception exception = assertThrows(ArithmeticException.class, () -> calculator.isDivisibleBy(10, 0));
		assertEquals("/ by zero", exception.getMessage(), "Division by zero should throw ArithmeticException");
	}
}
