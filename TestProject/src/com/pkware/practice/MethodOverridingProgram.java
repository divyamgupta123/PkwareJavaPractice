package com.pkware.practice;

class A {
	String x = "A class";

	void show() {
		System.out.println("A class method called");
	}
	
	void showX() {
		System.out.println(this.x + " data member");
	}
}

class B extends A {
	String x = "B class";

	void show() {
		System.out.println("B class method called");
	}
	void showX() {
		System.out.println(this.x + " data member");
	}
}

public class MethodOverridingProgram {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();

		System.out.println(a.x + " data member");
		System.out.println(b.x + " data member");
		System.out.println();
		
		a.show();
		b.show();
		System.out.println();
		
		a = b;
		System.out.println(a.x + " data member");
		System.out.println();
		
		a.showX();
		b.showX();

	}
}
