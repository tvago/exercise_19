package com.mycompany.app.output;

public class ConsoleOutput implements OutputDevice{
	@Override
	public void write(String message) {
		System.out.print(message);
	}
}
