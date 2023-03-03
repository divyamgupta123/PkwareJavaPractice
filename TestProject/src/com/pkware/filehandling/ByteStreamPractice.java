package com.pkware.filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamPractice {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("C:\\Users\\divyam.gupta\\eclipse-workspace\\TestProject\\testFile.txt");
			fos = new FileOutputStream("C:\\Users\\divyam.gupta\\eclipse-workspace\\TestProject\\testFile1.txt");

			int temp;

			while ((temp = fis.read()) != -1) {
				System.out.print((char)temp);
				fos.write(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
