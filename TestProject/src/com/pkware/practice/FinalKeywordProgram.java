package com.pkware.practice;


final class FinalClass{
	void show() {
		System.out.println("I am in Final class");
	}
}

//error - class FinalMethodClass extends FinalClass
class FinalMethodClass{
	final void show() {
		System.out.println("I am in Final method class");
	}
}

class NormalClass extends FinalMethodClass{
	//Cannot override the final method from FinalMethodClass
//	@Override
//	void show() {
//		
//	}
	
	final int x = 10;

	void showNormalClass(){
		System.out.println("I am in Normal Class");
	}
	
	//The final field NormalClass.x cannot be assigned
//	void setX(int x) {
//		this.x = x;
//	}
}

public class FinalKeywordProgram {
	public static void main(String[] args) {
		
		FinalClass finalClassObj = new FinalClass();
		FinalMethodClass finalMethodClassObj = new FinalMethodClass();
		NormalClass normalClassObj = new NormalClass();
		
		finalClassObj.show();
		System.out.println();
		
		finalMethodClassObj.show();
		System.out.println();
		
		normalClassObj.showNormalClass();
		
	}
}
