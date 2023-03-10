package com.pkware.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

class ComputerDivision {

	static int divide(int a, int b) {
		return divideByZero(a, b);
	}

	static int divideByZero(int a, int b) {
		return a / 0;
	}

	static void ThrowsMethod() throws IllegalAccessException {
		System.out.println("Throws Method Called");
		throw new IllegalAccessException("demo");
	}
}

class UserDefinedExp extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDefinedExp() {}

	UserDefinedExp(String s) {
		super(s);
	}
}

public class ExceptionHandlingProgram {
	public static void main(String[] args) throws IllegalAccessException {

		// Methods to print the Exception information
		System.out.println("Methods to print the Exception information");
		try {
			int x = 12 / 0;
		} catch (Exception e) {
			System.out.println("PrintStackTrace - ");
			e.printStackTrace();
			System.out.println();
			System.out.println("To String - ");
			System.out.println(e.toString());
			System.out.println();
			System.out.println("Get message - ");
			System.out.println(e.getMessage());
			System.out.println();
		}

		// Stack Trace Example
		System.out.println("Stack Trace Example");
		try {
			ComputerDivision.divide(10, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Multiple Exceptions
		System.out.println();
		System.out.println("Multiple Exception Handling");

		int choice = -1;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("Enter 1 to divide to integers");
			System.out.println("Enter 2 to get a character from string");
			System.out.println("Enter 3 to get String length");
			System.out.println("Enter 4 to exit");
			System.out.print("Enter Choice - ");
			try {
				choice = scan.nextInt();

				switch (choice) {
				case 1:
					System.out.print("Enter First Integer");
					int a = scan.nextInt();
					System.out.print("Enter second integer");
					int b = scan.nextInt();
					System.out.println("Result - " + (a / b));
					break;
				case 2:
					String name1 = "Divyam";
					System.out.print("Enter Index - ");
					int x = scan.nextInt();
					System.out.println("Result - " + name1.charAt(x));
					break;
				case 3:
					String name2 = null;
					System.out.println("Result - " + name2.length());
					break;
				case 4:
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
			} catch (ArithmeticException e) {
				System.out.println("ArithmeticException caught");
				e.printStackTrace();
				break;
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("StringIndexOutOfBoundsException caught");
				e.printStackTrace();
				break;
			} catch (NullPointerException e) {
				System.out.println("NullPointerException caught");
				e.printStackTrace();
				break;
			} catch (InputMismatchException e) {
				System.out.println("InputMismatchException caught");
				e.printStackTrace();
				break;
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		} while (choice != 4);

		// User Defined Exception
		System.out.println();
		System.out.println("User Defined Exception Example");
		try {
			System.out.print("Enter a number less than 10 - ");
			int x = scan.nextInt();
			if (x < 10) {
				throw new UserDefinedExp("Number is less than 10");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally block executed");
			scan.close();
		}

		// Throws Example
		System.out.println();
		System.out.println("Throws keyword example");

		try {
			ComputerDivision.ThrowsMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Program End");
	}
}
