package com.pkware.practice;

enum Directions{
	North,
	South,
	West,
	East
}

enum Fruits{
	Apple("Red"),
	Banana("Yellow"),
	Pear("Green"),
	Orange("Orange");
	
	private String color;
	
	Fruits(String color){
		this.color =color;
	}
	String getColor() {
		return this.color;
	}
	
}

public class EnumsProgram {
	public static void main(String[] args) {
		
		Directions dirNames[] = Directions.values();
		
		for(Directions dir:dirNames) {
			System.out.println(dir.name()+" at index of "+dir.ordinal());
		}
		System.out.println();
		
//		valueOf() method returns the enum constant of the specified string value if exists
		System.out.println((Object)Directions.valueOf("North").getClass().getSimpleName());
		System.out.println();
		
		Fruits fruits[] = Fruits.values();
		
		for(Fruits fr:fruits) {
			System.out.println(fr.ordinal()+1 + ". Color of "+fr.name()+" is "+fr.getColor());
		}
		
		
	}
}
