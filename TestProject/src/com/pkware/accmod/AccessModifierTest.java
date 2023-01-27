package com.pkware.accmod;

class ChildClass2 extends SuperClass{
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

public class AccessModifierTest{

	public static void main(String[] args) {
		ChildClass2 obj = new ChildClass2();
		
		obj.callDefaultMethod();
		obj.callProtectedMethod();
		obj.callPublicMethod();
//		obj.callPrivateMethod();
	}

}
