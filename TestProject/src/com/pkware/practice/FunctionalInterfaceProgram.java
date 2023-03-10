package com.pkware.practice;

@FunctionalInterface
interface Square{
	int calculate(int x);
}

public class FunctionalInterfaceProgram {

	public static void main(String[] args) {
		Square s = (int x)->x*x;
		System.out.println(s.calculate(5));
	}

}
