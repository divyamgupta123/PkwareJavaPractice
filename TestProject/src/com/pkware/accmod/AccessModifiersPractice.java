package com.pkware.accmod;

class SuperClass{
	void displayDefaultMethod() {
		System.out.println("I am in Default Method");
	}
	private void displayPrivateMethod() {
		System.out.println("I am in Private Method");
	}
	protected void displayProctectedMethod() {
		System.out.println("I am in Protected Method");
	}
	public void displayPublicMethod() {
		System.out.println("I am in Public Method");
	}
}

class ChildClass extends SuperClass{
	void callDefaultMethod() {
		super.displayDefaultMethod();
	}
	
//	void callPrivateMethod() {
//		super.displayPrivateMethod();
//	}
	
	void callPublicMethod() {
		super.displayPublicMethod();
	}
	void callProtectedMethod() {
		super.displayProctectedMethod();
	}
}


public class AccessModifiersPractice {
	
	void displayDefaultMethod() {
		System.out.println("I am in Default Method");
	}
	private void displayPrivateMethod() {
		System.out.println("I am in Private Method");
	}
	protected void displayProctectedMethod() {
		System.out.println("I am in Protected Method");
	}
	public void displayPublicMethod() {
		System.out.println("I am in Public Method");
	}

	
	public static void main(String[] args) {
		ChildClass obj = new ChildClass();
		
		obj.callDefaultMethod();
		obj.callProtectedMethod();
		obj.callPublicMethod();
//		obj.callPrivateMethod();
		
	}
	
}
