package com.mycompany.app.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.app.conf.Condition;
import com.mycompany.app.conf.Config;
import com.mycompany.app.output.ConsoleOutput;
import com.mycompany.app.utils.Calculator;

class PrinterServiceTest {

	private PrinterService printerService;
	private Calculator calculator;
	private Config config;
	private ConsoleOutput consoleOutput;

	/*
	* Needed to setup mocked data before each test
	* */
	@BeforeEach
	void setUp() {
		calculator = mock(Calculator.class);
		consoleOutput = mock(ConsoleOutput.class);
		config = mock(Config.class);
		printerService = new PrinterService();
		printerService.calculator = calculator; // Inject mocked Calculator
	}

	@Test
	void testUsePrinter_NumberWithoutCondition() {
		when(config.getNumberArray()).thenReturn(new ArrayList<>(Arrays.asList(1, 2, 3)));
		when(config.getConditions()).thenReturn(new ArrayList<>());

		printerService.usePrinter(config,consoleOutput);

		verify(config, times(1)).getNumberArray();
		verify(config, times(3)).getConditions();
	}

	@Test
	void testUsePrinter_NumberWithConditionMatched() {
		Condition condition = mock(Condition.class);
		when(condition.getNumber()).thenReturn(2);
		when(condition.getTextOutput()).thenReturn("Divisible by 2");

		when(config.getNumberArray()).thenReturn(new ArrayList<>(Arrays.asList(2, 4)));
		when(config.getConditions()).thenReturn(new ArrayList<>(Arrays.asList(condition)));

		when(calculator.isDivisibleBy(2, 2)).thenReturn(true);
		when(calculator.isDivisibleBy(4, 2)).thenReturn(true);

		printerService.usePrinter(config,consoleOutput);

		verify(config, times(1)).getNumberArray();
		verify(config, times(2)).getConditions();
		verify(calculator, times(1)).isDivisibleBy(2, 2);
		verify(calculator, times(1)).isDivisibleBy(4, 2);
	}

	@Test
	void testUsePrinter_NumberWithConditionNotMatched() {

		Condition condition = mock(Condition.class);
		when(condition.getNumber()).thenReturn(5);
		when(condition.getTextOutput()).thenReturn("Divisible by 5");

		when(config.getNumberArray()).thenReturn(new ArrayList<>(Arrays.asList(2, 3)));
		when(config.getConditions()).thenReturn(new ArrayList<>(Arrays.asList(condition)));

		when(calculator.isDivisibleBy(2, 5)).thenReturn(false);
		when(calculator.isDivisibleBy(3, 5)).thenReturn(false);

		printerService.usePrinter(config,consoleOutput);

		verify(config, times(1)).getNumberArray();
		verify(config, times(2)).getConditions();
		verify(calculator, times(1)).isDivisibleBy(2, 5);
		verify(calculator, times(1)).isDivisibleBy(3, 5);
	}
}