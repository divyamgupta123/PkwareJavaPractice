package com.pkware.practice;

public class StringsPrac {
	
	public static void concatWithString() {
		String t = "Divyam";
		
		for (int i = 0; i < 1000; i++) {
			t = t+"Divyam";
		}
	}
	
	
	public static void concatWithStringBuffer() {
		StringBuffer t = new StringBuffer("Divyam");
		for (int i = 0; i < 1000; i++) {
			t.append("Divyam");
		}
	}
	
	public static void main(String[] args) {
		char data[] = {'a','b'};
		System.out.println(data);
		String charArr = new String(data,1,1);
		System.out.println(charArr);
		
		
		String test1 = new String("Divyam");
		String test2 = "Divyam";
		System.out.println(test1.compareTo("divyam"));
		System.out.println(test1.compareToIgnoreCase("divyam"));
		System.out.println(test1.compareTo(test2));
		
		
		System.out.println(test1.concat(test2));
		System.out.println(test1.contains("div"));
		System.out.println(test1.contains("vyam"));
		
		
		char data2[] = {'G','u','p','t','a'};
		System.out.println(String.copyValueOf(data2));
		
		String test3 = new String(data2);
		System.out.println(test3.endsWith("ta"));
		
		
		System.out.println(String.valueOf(23.42424));
		
		System.out.println("3 + 3 = " + 3+3);
		
		test1.getChars(0, 0, data2, 0);
		
		
		StringBuffer test4 = new StringBuffer("Hello World");
		System.out.println(test4.length());
		System.out.println(test4.capacity());
		test4.setLength(1000);
		System.out.println(test4);
		System.out.println(test4.length());
		test4.trimToSize();
		System.out.println(test4);
		
		
		//String vs StringBuffer Performance Test
		
		
		Long currentTime = System.currentTimeMillis();
		concatWithString();
		System.out.println("Time taken in Strings = "+(System.currentTimeMillis()-currentTime));
		
		currentTime = System.currentTimeMillis();
		concatWithStringBuffer();
		System.out.println("Time taken in StrinBuffer = "+(System.currentTimeMillis()-currentTime));
		
		
		//== vs Equals
		
		String test5 = "Divyam";
		String test6 = "Divyam";
		
		System.out.println("String == "+(test5 == test6));
		System.out.println("String Equals "+(test5.equals(test6)));
		
		String test7 = new String("Divyam");
		String test8 = new String("Divyam");
		
		System.out.println("String == "+(test7 == test8));
		System.out.println("String Equals == "+(test7.equals(test8)));
		
		
	}
}
