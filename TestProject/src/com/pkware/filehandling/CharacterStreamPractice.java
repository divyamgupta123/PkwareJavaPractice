package com.pkware.filehandling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamPractice {
	public static void main(String[] args) {
		FileReader reader = null;
		FileWriter writer = null;

		try {
			reader = new FileReader("C:\\Users\\divyam.gupta\\eclipse-workspace\\TestProject\\testFile.txt");
			writer = new FileWriter("C:\\Users\\divyam.gupta\\eclipse-workspace\\TestProject\\testFile2.txt");

			int temp;

			while ((temp = reader.read()) != -1) {
				System.out.print((char)temp);
				writer.write(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
