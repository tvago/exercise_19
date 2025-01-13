package com.mycompany.app.output;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

public class FileOutputTest {

	private File tempFile;
	private FileOutput fileOutput;

	@BeforeEach
	void setUp() throws IOException {
		tempFile = File.createTempFile("test_output", ".txt");
		tempFile.deleteOnExit(); // Ensure the file is deleted after the test
		fileOutput = new FileOutput() {
			@Override
			public void write(String message) {
				try (PrintWriter writer = new PrintWriter(new FileWriter(tempFile, true))) {
					writer.println(message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
	}

	@Test
	void testWrite_SingleMessage() throws IOException {
		String message = "Hello, File!";

		fileOutput.write(message);

		try (BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
			assertEquals("Hello, File!", reader.readLine());
			assertNull(reader.readLine()); // Ensure no additional lines exist
		}
	}

	@Test
	void testWrite_MultipleMessages() throws IOException {
		String message1 = "First Line";
		String message2 = "Second Line";

		fileOutput.write(message1);
		fileOutput.write(message2);

		try (BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
			assertEquals("First Line", reader.readLine());
			assertEquals("Second Line", reader.readLine());
			assertNull(reader.readLine()); // Ensure no additional lines exist
		}
	}

	@Test
	void testWrite_EmptyMessage() throws IOException {
		String message = "";

		fileOutput.write(message);

		try (BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
			assertEquals("", reader.readLine()); // Ensure empty line is written
			assertNull(reader.readLine()); // Ensure no additional lines exist
		}
	}
}

