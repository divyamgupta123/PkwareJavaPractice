package com.pkware.practice;

import com.pkware.accmod.AccessModifiersPractice;

class ChildClass extends AccessModifiersPractice{
//	void callDefaultMethod() {
//		super.displayDefaultMethod();
//	}
	
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


public class AccModImportClass {
	public static void main(String[] args) {
		ChildClass obj = new ChildClass();
		
//		obj.callDefaultMethod();
		obj.callProtectedMethod();
		obj.callPublicMethod();
//		obj.callPrivateMethod();
		
		AccessModifiersPractice obj1 = new AccessModifiersPractice();
		System.out.println();
		System.out.println("Public Method accessible without extending too");
		obj1.displayPublicMethod();
		
	}
}
