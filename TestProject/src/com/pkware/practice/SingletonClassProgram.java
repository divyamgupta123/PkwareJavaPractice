package com.pkware.practice;

class SingletonClass{
	static SingletonClass instance = null;
	int x;
	
	public SingletonClass() {
		x = 10;
	}
	
	static SingletonClass getInstance() {
		if(instance == null) {
			instance = new SingletonClass();
		}
		return instance;
	}
	
}

public class SingletonClassProgram {
	public static void main(String[] args) {
		SingletonClass obj1 = SingletonClass.getInstance();
		SingletonClass obj2 = SingletonClass.getInstance();
		
		obj1.x = obj1.x+12;
		
		System.out.println("Obj1 x = "+obj1.x);
		System.out.println("Obj2 x = "+obj2.x);
		
	}
}
