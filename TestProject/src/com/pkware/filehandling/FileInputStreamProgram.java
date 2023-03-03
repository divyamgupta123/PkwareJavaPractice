package com.pkware.filehandling;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamProgram {
	public static void main(String[] args) throws IOException{
		int size;
		
		InputStream fis = new FileInputStream("C:\\Users\\divyam.gupta\\eclipse-workspace\\TestProject\\src\\com\\pkware\\filehandling\\ByteStreamPractice.java");
		
		size = fis.available();
		System.out.println("Total available bytes - "+size);
		
		int n = size/40;
		System.out.println("First "+n+" bytes of the file one read() at a time");
		for(int i=0;i<n;i++) {
			System.out.print((char)fis.read());
		}
		
		System.out.println("\nStill Available bytes - "+fis.available());
		System.out.println("Reading next "+n+" with one read(b[n])");
		byte b[] = new byte[n];
		
		if(fis.read(b)!=n) {
			System.err.println("Couldn't read "+n+" bytes.");
		}
		
		System.out.println(new String(b,0,n));
		System.out.println("Still remaining bytes - "+(size = fis.available()));
		
		System.out.println("Skipping half of the remaining bytes with skip()");
		fis.skip(size/2);
		
		System.out.println("Still available - "+fis.available());
		
		System.out.println("Reading "+n/2+" into end of the array");
		if(fis.read(b,n/2,n/2)!=n/2) {
			System.err.println("Couldn't read "+n/2+" bytes.");
		}
		System.out.println(new String(b,0,b.length));
		System.out.println("Still available - "+fis.available());
	}
	
}
