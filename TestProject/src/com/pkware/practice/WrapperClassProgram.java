package com.pkware.practice;

public class WrapperClassProgram {

	public static void main(String[] args) {

		// Auto Boxing

		int a = 10;
		Integer intObj = a;

		Character chObj = 'a';

		double db = 23.2222;
		Double dbObj = db;
		// Deprecated
		// Double dbObj = new Double(db);
		
		System.out.println("Integer Object : "+intObj);
		System.out.println("Character Object : "+chObj);
		System.out.println("Double Object : "+dbObj);
		System.out.println();
		
		int intPri = intObj;
		char chPri = chObj;
		double dbPri = dbObj;
		
		System.out.println("Int Primitve : "+intPri);
		System.out.println("Char Primitve : "+chPri);
		System.out.println("Double Primitve : "+dbPri);
		
	}

}
