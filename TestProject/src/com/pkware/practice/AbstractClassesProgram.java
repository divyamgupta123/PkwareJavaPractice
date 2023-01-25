package com.pkware.practice;

abstract class Figure{
	double dim1;
	double dim2;
	Figure(double dim1,double dim2){
		this.dim1 = dim1;
		this.dim2 = dim2;
	}
	
	abstract double area();
}

class Rectangle extends Figure{

	Rectangle(double dim1, double dim2) {
		super(dim1, dim2);
	}
	
	double area() {
		System.out.println("Inside area of rectangle");
		return dim1*dim2;
	}
}

class Triangle extends Figure{
	
	Triangle(double dim1, double dim2) {
		super(dim1, dim2);
	}
	
	double area() {
		System.out.println("Inside area of Triangle");
		return dim1*dim2/2;
	}
}

public class AbstractClassesProgram {

	public static void main(String[] args) {
		//Figure fig = new Figure()
		Rectangle rect = new Rectangle(10,20);
		Triangle tri = new Triangle(10, 10);
		
		Figure figref;
		
		figref = rect;
		System.out.println("Area of Rectangle : "+figref.area());
		figref = tri;
		System.out.println("Area of Triangle : "+figref.area());
		
	}

}
