package com.mycompany.app.output;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOutput implements OutputDevice {
	@Override
	public void write(String message) {
		try (PrintWriter writer = new PrintWriter(new FileWriter("output.txt", true))) {
			writer.println(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}