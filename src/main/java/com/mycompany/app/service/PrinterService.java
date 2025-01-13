package com.mycompany.app.service;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.app.conf.Condition;
import com.mycompany.app.conf.Config;
import com.mycompany.app.output.OutputDevice;
import com.mycompany.app.utils.Calculator;


public class PrinterService {

	Calculator calculator = new Calculator();
	List<Condition> conditionsToApply = new ArrayList<>();

	/**
	 * Processes a given configuration to apply conditions to a list of numbers and print the results.
	 *
	 * For each number in the provided config, the method checks which conditions from the
	 * configuration are satisfied. If no conditions are met for a number, the number itself is printed.
	 * If conditions are met, their respective text outputs are printed instead.
	 *
	 */
	public void usePrinter(Config config, OutputDevice outputDevice) {
		for (Integer number : config.getNumberArray()) {
			config.getConditions().forEach(condition -> {
				if (applyCondition(condition, number)) {
					conditionsToApply.add(condition);
				}
			});

			if (conditionsToApply.isEmpty()) {
				System.out.println(number);
			} else {
				for (Condition condition : conditionsToApply) {
					System.out.print(condition.getTextOutput());
				}
				conditionsToApply.clear();
				System.out.println();
			}
		}
	}

	/**
	 * Checks if a number meets the specified condition.
	 *
	 * @param condition the condition to evaluate, which contains the divisor.
	 * @param number the number to check.
	 * @return {@code true} if the number is divisible by the divisor in the condition, {@code false} otherwise.
	 */
	private boolean applyCondition(Condition condition, Integer number) {
		if(calculator.isDivisibleBy(number, condition.getNumber())) {
			return true;
		}
		return false;
	}
}
