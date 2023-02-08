package com.pkware.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Cloneable;

class MarkerTestClass implements Cloneable,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	int rollNo;

	public MarkerTestClass(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}
	
	public void display() {
		System.out.println("Roll Number "+this.rollNo+" - "+this.name);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}


public class MarkerInterfacesProgram {

	public static void main(String[] args) throws IOException,ClassNotFoundException{
		MarkerTestClass cltObj = new MarkerTestClass("Divyam", 12);

//		try {
//			MarkerTestClass cltObj2 = (MarkerTestClass) cltObj.clone();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			MarkerTestClass cltObj2 = (MarkerTestClass) cltObj.clone();
			cltObj2.display();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
        FileOutputStream fos = new FileOutputStream("xyz.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(cltObj);
  
        FileInputStream fis = new FileInputStream("xyz.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        MarkerTestClass cltObj3 = (MarkerTestClass)ois.readObject();
  
        cltObj3.display();
  
        oos.close();
        ois.close();

	}

}
