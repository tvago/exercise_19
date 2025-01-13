package com.mycompany.app.output;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class ConsoleOutputTest {

	private ByteArrayOutputStream outContent;
	private ConsoleOutput consoleOutput;

	@BeforeEach
	void setUp() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		consoleOutput = new ConsoleOutput();
	}

	@Test
	void testWrite_SingleMessage() {
		String message = "Hello, World!";

		consoleOutput.write(message);

		assertEquals("Hello, World!", outContent.toString());
	}

	@Test
	void testWrite_MultipleMessages() {
		String message1 = "Hello, ";
		String message2 = "World!";

		consoleOutput.write(message1);
		consoleOutput.write(message2);

		assertEquals("Hello, World!", outContent.toString());
	}

	@Test
	void testWrite_EmptyMessage() {

		String message = "";
		consoleOutput.write(message);
		assertEquals("", outContent.toString());
	}
}

