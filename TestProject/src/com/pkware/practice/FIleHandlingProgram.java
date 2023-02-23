package com.pkware.practice;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FIleHandlingProgram {

	public static void main(String[] args) {

		String fileName = "testFile.txt";

		try {
			File fileObj = new File(fileName);
			if (fileObj.createNewFile()) {
				System.out.println("New File created - " + fileObj.getName());
			} else {
				System.out.println("File already exists!");
			}

			
			FileWriter writerObj = new FileWriter(fileName);
			writerObj.write("Hey, this is a new new text file made using JAVA file handling!!!");
			writerObj.write("\nI have written this to file.");
			writerObj.write("I am using JDK version 11");
			writerObj.close();
			
			System.out.println("Can read this file - "+fileObj.canRead());
			System.out.println("Can write this file - "+fileObj.canWrite());
			System.out.println("Size of file - "+fileObj.length());
			System.out.println("List of files in the directory - "+fileObj.list());
			System.out.println("Absolute path of file - "+fileObj.getAbsolutePath());

			
			System.out.println("Contents of the file - ");
			Scanner fileReader = new Scanner(fileObj);
			while (fileReader.hasNextLine()) {
				System.out.print(fileReader.nextLine());
			}
			fileReader.close();
			
//			if(fileObj.delete()) {
//				System.out.println("File deleted - "+fileObj.getName());
//			}else {
//				System.out.println("Can't delete file");
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
