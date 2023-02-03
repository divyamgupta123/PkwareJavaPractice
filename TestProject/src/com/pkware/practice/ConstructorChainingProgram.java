package com.pkware.practice;

class Numbers{
	public Numbers() {
		this(5);
		System.out.println("Numbers default constructor");
	}
	
	public Numbers(int x) {
		this(2,x);
		System.out.println("X = "+x);
	}
	
	public Numbers(int power,int x) {
		System.out.println(x+" raise to power "+power+" "+Math.pow(x, power));
	}
}


public class ConstructorChainingProgram {
	public static void main(String[] args) {
		Numbers numObj = new Numbers();
	}
}
