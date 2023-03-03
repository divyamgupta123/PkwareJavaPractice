package com.pkware.filehandling;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamProgram {

	public static void main(String[] args) throws IOException {
		String source = "Now is the time for all good men\n" + " to come to the aid of their country\n"
				+ " and pay their due taxes.";
		
		byte buf[] = source.getBytes();
		
		OutputStream fos = new FileOutputStream("file1.txt");
		
		for(int i=0;i<buf.length;i+=2) {
			fos.write(buf[i]);
		}
		
		fos.close();
		
		OutputStream fos1 = new FileOutputStream("file2.txt");
		fos1.write(buf);
		fos1.close();
		
		OutputStream fos2 = new FileOutputStream("file3.txt");
		fos2.write(buf,buf.length-buf.length/4,buf.length/4);
		fos2.close();
		
		
	}

}
