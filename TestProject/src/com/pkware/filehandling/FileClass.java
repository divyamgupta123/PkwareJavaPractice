package com.pkware.filehandling;

import java.io.File;

public class FileClass {

	public static void main(String[] args) {
		File fileObj = new File("testFile.txt");
		
		System.out.println("File Name - "+fileObj.getName());
		System.out.println("File Path - "+fileObj.getPath());
		System.out.println("File Absolute Path - "+fileObj.getAbsolutePath());
		System.out.println("File Parent - "+fileObj.getParent());
		System.out.println("Do file Exist - "+fileObj.exists());
		System.out.println("Can write to file - "+fileObj.canWrite());
		System.out.println("Is a Directory - "+fileObj.isDirectory());
		System.out.println("Is a File - "+fileObj.isFile());
		System.out.println("File last modified on - "+fileObj.lastModified());
		System.out.println("File size - "+fileObj.length());
		
		System.out.println();
		System.out.println();
		
		// Directory operations
		String dirName = "C:\\Users\\divyam.gupta\\eclipse-workspace\\TestProject";
		File fileObj1 = new File(dirName);
		if(fileObj1.isDirectory()) {
			String[] listDir = fileObj1.list();
			for(int i=0;i<listDir.length;i++) {
				File f = new File(dirName+"\\"+listDir[i]);
				if(f.isDirectory()) {
					System.out.println(listDir[i]+" is a directory");
				}else {
					System.out.println(listDir[i]+" is a file");	
				}
			}	
		}else {
			System.out.println(dirName+" is not a directory");			
		}
	}

}
