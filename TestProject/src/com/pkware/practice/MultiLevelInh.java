package com.pkware.practice;

class Box{
	private double width;
	private double height;
	private double depth;
	
	Box(){
		width = -1;
		height = -1;
		depth = -1;
	}
	
	Box(double len){
		width = height = depth = len;
	}
	
	Box(double width,double height,double depth){
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	Box(Box ob){
		width = ob.width;
		height = ob.height;
		depth = ob.depth;
	}
	
	double volume(){
		return (this.width*this.height*this.depth);
	}
}

class BoxWeight extends Box{
	double weight;
	
	public BoxWeight() {
		super();
		weight = -1;
	}
	
	BoxWeight(double len,double weight){
		super(len);
		this.weight = weight;
	}
	
	BoxWeight(double width,double height, double depth, double weight){
		super(width,height,depth);
		this.weight = weight;
	}
	
	BoxWeight(BoxWeight ob){
		super(ob);
		this.weight = ob.weight;
	}
}

class Shipment extends BoxWeight{
	double cost;
	
	Shipment(){
		super();
		cost = -1;
	}
	
	Shipment(double len,double weight,double cost){
		super(len,weight);
		this.cost = cost;
	}
	
	Shipment(double width,double height, double depth, double weight, double cost){
		super(width,height,depth,weight);
		this.cost = cost;
	}
	
	Shipment(Shipment ob){
		super(ob);
		this.cost = ob.cost;
	}
}

public class MultiLevelInh {

	public static void main(String[] args) {
		Shipment shp1 = new Shipment(10,20,15,10,3.41);
		Shipment shp2 = new Shipment(20,30,1.2);
		Shipment shp3 = new Shipment(shp2);
		
		System.out.println("Shipment 1 volume : " + shp1.volume());
		System.out.println("Shipment 1 weight : " + shp1.weight);
		System.out.println("Shipment 1 cost : " + shp1.cost);
		System.out.println();
		System.out.println("Shipment 3 volume : " + shp3.volume());
		System.out.println("Shipment 3 weight : " + shp3.weight);
		System.out.println("Shipment 3 cost : " + shp3.cost);
	}

}
