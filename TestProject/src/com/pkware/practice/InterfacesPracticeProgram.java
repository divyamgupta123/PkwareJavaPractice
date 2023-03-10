package com.pkware.practice;

interface Polygon{
	void printSides(int sides);
}


class Quadilateral implements Polygon{

	@Override
	public void printSides(int sides) {
		System.out.println("Quadilateral has "+sides+" sides");
	}
	void showQuadilateral() {
		System.out.println("I am in Quadilateral");
	}
	
	public interface SubType{
		void typeName();
	}

}

class Hexagon implements Polygon,Quadilateral.SubType{

	@Override
	public void printSides(int sides) {
		System.out.println("Hexagon has "+sides+" sides");
	}
	void showTriangle() {
		System.out.println("I am in Triangle");
	}
	@Override
	public void typeName() {
		System.out.println("I am in Regular Hexagon");
	}

}

class Pentagon implements Polygon{

	@Override
	public void printSides(int sides) {
		System.out.println("Pentagon has "+sides+" sides");
	}

	
	void showPentagon() {
		System.out.println("I am in Pentagon");
	}
}


abstract class Octagon implements Polygon{
//
//	@Override
//	public void printSides(int sides) {
//		System.out.println("Pentagon has "+sides+" sides");
//	}
	
	void showPentagon() {
		System.out.println("I am in Octagon");
	}
}

public class InterfacesPracticeProgram {

	public static void main(String[] args) {
		Quadilateral quad = new Quadilateral();
		Hexagon hex = new Hexagon();
		Pentagon pent = new Pentagon();
		
		quad.printSides(4);
		System.out.println();
		
		hex.printSides(6);
		System.out.println();
		
		pent.printSides(5);
		System.out.println();
		
		
		Polygon py;
		
		py = quad;
		py.printSides(4);
		System.out.println();
		
		py = hex;
		py.printSides(6);
		System.out.println();
		
		py = pent;
		py.printSides(5);
		System.out.println();
//		py.showPentagon();
		
		
//		Octagon oct = new Octagon() {
//			
//			@Override
//			public void printSides(int sides) {
//				
//			}
//		};
		
	}

}
