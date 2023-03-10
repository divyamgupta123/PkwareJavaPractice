package com.pkware.practice;


class Company{
	private int numEmp;
	private String name;
	
	public Company() {
		System.out.println("Default Constructor Called!!!!");
		System.out.println("Name - "+this.name);
		System.out.println("Num Employees - "+this.numEmp);
	}
	
	public Company(String name,int numEmp) {
		System.out.println("Parameterized Constructor Called!!!!");
		this.name = name;
		this.numEmp = numEmp;
		System.out.println("Name - "+this.name);
		System.out.println("Num Employees - "+this.numEmp);
	}
	
	public Company(Company obj) {
		System.out.println("Copy Constructor Called!!!!");
		this.name = obj.name;
		this.numEmp = obj.numEmp;
		System.out.println("Name - "+this.name);
		System.out.println("Num Employees - "+this.numEmp);
	}
}

public class ConstructorProgram {

	public static void main(String[] args) {
		Company cmp1 = new Company();
		System.out.println(System.getProperty("java.runtime.version"));
		System.out.println();
		Company cmp2 = new Company("Pkware",200);
		System.out.println();
		Company cmp3 = new Company(cmp2);
	}

}
