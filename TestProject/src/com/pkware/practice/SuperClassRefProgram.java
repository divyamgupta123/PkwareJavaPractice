package com.pkware.practice;

class NewBox{
	int width;
	int height;
	int depth;
	
	NewBox(){
		width = -1;
		height = -1;
		depth = -1;
	}
	
	NewBox(int width,int height,int depth){
		this.depth = depth;
		this.height = height;
		this.width = width;
	}
	
	int volume() {
		return width*height*depth;
	}
	
	void display() {
		System.out.println("Box class called");
		System.out.println("Width = "+width + " Height = "+height+" Depth = "+depth);
	}
}

class NewBoxWeight extends NewBox{
	int weight;
	public NewBoxWeight() {
		weight = -1;
	}
	NewBoxWeight(int weight){
		this.weight = weight;
	}
	
	void cost(){
		System.out.println("Shipment cost is 1 Rs/kg");
	}
	
	@Override
	void display() {
		System.out.println("Box Weight class called");
		System.out.println("Weight = "+weight);
	}
}

public class SuperClassRefProgram {
	public static void main(String[] args) {
		NewBox box1 = new NewBox(10,20,30);
		NewBoxWeight boxW1 = new NewBoxWeight(100);
		
		box1.display();
		System.out.println();
		boxW1.display();
		System.out.println();
		
		NewBox box2 = new NewBoxWeight(200);
		
		box2.display();
		box2.volume();
		
//		It is important to understand that it is the type of the reference variable—not the type of
//		the object that it refers to—that determines what members can be accessed. That is, when a
//		reference to a subclass object is assigned to a superclass reference variable, you will have access
//		only to those parts of the object defined by the superclass
		
//		box2.cost();
	}
	
	

}
