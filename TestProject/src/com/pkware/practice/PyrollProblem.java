package com.pkware.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
1. A company pays its employees on a weekly basis. The employees are of four types: 
a. Salaried employees are paid a fixed weekly salary regardless of the number of hours worked, 
b. hourly employees are paid by the hour and receive overtime pay (i.e., 1.5 times their hourly salary rate) for all hours worked in excess of 40 hours, 
c. commission employees are paid 15 percent of their sales and 
d. base-salaried commission employees receive a base salary plus 12 percent of their sales.
For the current pay period, the company has decided to reward bonus to base-salaried-commission employees by adding 10% to their base salaries.
Write an java program that performs its payroll calculations.
​
Please enhance Payroll application to:
Take personal data as input such as email, phone etc
In the end prompt user for employee name and prints its payroll and details

*/

enum EmployeeType {
	SalariedEmp("SALEMP"), HourlyEmp("HRYEMP"), CommissionedEmp("CMSEMP"), BaseSalariedEmp("BSEMP");

	private String empTypeCode;

	private EmployeeType(String empTypeCode) {
		this.empTypeCode = empTypeCode;
	}

	String getEmpTypeCode() {
		return this.empTypeCode;
	}
}

interface EmployeeInterface {
	void empDetails(String name, String email, String phone, String empType);

	double empPayroll();

	String getName();

	String getEmail();

	String getPhone();

	String printEmpType();
	
	String getEmpTypeCode();
}

class SalariedEmploee implements EmployeeInterface {

	// Salaried employees are paid a fixed weekly salary regardless of the number of
	// hours worked
	String name;
	String email;
	String phone;
	String empTypeCode;
	final int WEEKLYSALARY = 10000;

	public SalariedEmploee() {
	}

	public void empDetails(String name, String email, String phone, String empTypeCode) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.empTypeCode = empTypeCode;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhone() {
		return this.phone;
	}

	public String printEmpType() {
		return new String("Salaried Employee");
	}
	
	public double empPayroll() {
		return WEEKLYSALARY;
	}
	
	public String getEmpTypeCode() {
		return this.empTypeCode;
	}
}

class HourlyEmployee implements EmployeeInterface {
	// hourly employees are paid by the hour and receive overtime pay
	// (i.e., 1.5 times their hourly salary rate) for all hours worked in excess of
	// 40 hours

	String name;
	String email;
	String phone;
	String empTypeCode;
	int hoursWorked;
	final int HOURLYWAGE = 100;

	public HourlyEmployee() {
	}

	public void empDetails(String name, String email, String phone, String empTypeCode) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.empTypeCode = empTypeCode;
		this.hoursWorked = 0;
	}

	public double empPayroll() {
		if (hoursWorked <= 40)
			return hoursWorked * HOURLYWAGE;
		return (40 * HOURLYWAGE) + (1.5 * HOURLYWAGE * (hoursWorked - 40));
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhone() {
		return this.phone;
	}

	public String printEmpType() {
		return new String("Hourly Employee");
	}
	
	public String getEmpTypeCode() {
		return this.empTypeCode;
	}

	int getHoursWorked() {
		return this.hoursWorked;
	}

	void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
}

class CommissionedEmployee implements EmployeeInterface {

	// commission employees are paid 15 percent of their sales
	String name;
	String email;
	String phone;
	String empTypeCode;

	double totalSales;

	public CommissionedEmployee() {
	}

	public void empDetails(String name, String email, String phone, String empTypeCode) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.empTypeCode = empTypeCode;
		this.totalSales = 0;
	}

	public double empPayroll() {
		return (0.15 * totalSales);
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhone() {
		return this.phone;
	}

	public String printEmpType() {
		return new String("Commissioned Employee");
	}
	
	public String getEmpTypeCode() {
		return this.empTypeCode;
	}

	void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}

	double getTotalSales() {
		return this.totalSales;
	}

}

class BaseSalariedEmployee implements EmployeeInterface {

	// base-salaried commission employees receive a base salary plus 12 percent of
	// their sales
	//For the current pay period, the company has decided to 
	//reward bonus to base-salaried-commission employees by adding 10% to their base salaries.
	String name;
	String email;
	String phone;
	String empTypeCode;
	double totalSales;
	final int BASESALARY = 1000;

	public BaseSalariedEmployee() {
	}

	public void empDetails(String name, String email, String phone, String empTypeCode) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.empTypeCode = empTypeCode;
		this.totalSales = 0;
	}

	public double empPayroll() {
		return (1.1*BASESALARY + 0.12 * totalSales);
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhone() {
		return this.phone;
	}

	public String printEmpType() {
		return new String("Base-Salaried Employee");
	}
	
	public String getEmpTypeCode() {
		return this.empTypeCode;
	}

	double getTotalSales() {
		return this.totalSales;
	}

	void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}
}

class EmployeeFactory {
	public EmployeeInterface createEmp(Scanner scan, String empType) {
		String name, email, phone;
		System.out.print("Enter name of employee - ");
		name = scan.next();
		System.out.print("Enter email of employee - ");
		email = scan.next();
		System.out.print("Enter phone of employee - ");
		phone = scan.next();

		EmployeeInterface emp;

		if (empType.equals(EmployeeType.SalariedEmp.getEmpTypeCode())) {
			emp = new SalariedEmploee();
			emp.empDetails(name, email, phone, empType);
			return emp;
		}
		if (empType.equals(EmployeeType.HourlyEmp.getEmpTypeCode())) {
			emp = new HourlyEmployee();
			emp.empDetails(name, email, phone, empType);
			return emp;
		}
		if (empType.equals(EmployeeType.CommissionedEmp.getEmpTypeCode())) {
			emp = new CommissionedEmployee();
			emp.empDetails(name, email, phone, empType);
			return emp;
		}
		if (empType.equals(EmployeeType.BaseSalariedEmp.getEmpTypeCode())) {
			emp = new BaseSalariedEmployee();
			emp.empDetails(name, email, phone, empType);
			return emp;
		}
		return null;
	}
}

public class PyrollProblem {

	public static void main(String[] args) {
		List<EmployeeInterface> empLst = new ArrayList<>();

		Scanner scan = new Scanner(System.in);
		int mmChoice = -1;
		EmployeeFactory empFacObj = new EmployeeFactory();

		System.out.println("--------- Program Entered ---------");
		do {
			System.out.println();
			System.out.println("Enter 1 to add an employee");
			System.out.println("Enter 2 to calculate payroll");
			System.out.println("Enter 3 to display all employees details");
			System.out.println("Enter 0 to exit program");
			System.out.print("Enter choice - ");
			mmChoice = scan.nextInt();

			switch (mmChoice) {
			case 1: {
				double totalSales = 0;
				int empType = -1;
				do {
					System.out.println();
					System.out.println("Enter 1 to add Salaried Employee");
					System.out.println("Enter 2 to add Hourly Employee");
					System.out.println("Enter 3 to add Commissioned Employee");
					System.out.println("Enter 4 to add Base-Salaried Employee");
					System.out.println("Enter 0 to continue");
					System.out.print("Enter choice - ");
					empType = scan.nextInt();

					switch (empType) {
					case 1: {
						EmployeeInterface emp = empFacObj.createEmp(scan, EmployeeType.SalariedEmp.getEmpTypeCode());
						empLst.add(emp);
						break;
					}
					case 2: {
						EmployeeInterface emp = empFacObj.createEmp(scan, EmployeeType.HourlyEmp.getEmpTypeCode());
						System.out.print("Total hours worked by employee - ");
						int hoursWorked = scan.nextInt();
						((HourlyEmployee) emp).setHoursWorked(hoursWorked);
						empLst.add(emp);
						break;
					}
					case 3: {
						EmployeeInterface emp = empFacObj.createEmp(scan,
								EmployeeType.CommissionedEmp.getEmpTypeCode());
						System.out.print("Total sales done by employee - ");
						totalSales = scan.nextDouble();
						((CommissionedEmployee) emp).setTotalSales(totalSales);
						empLst.add(emp);
						break;
					}
					case 4: {
						EmployeeInterface emp = empFacObj.createEmp(scan,
								EmployeeType.BaseSalariedEmp.getEmpTypeCode());
						System.out.print("Total sales done by employee - ");
						totalSales = scan.nextDouble();
						((BaseSalariedEmployee) emp).setTotalSales(totalSales);
						empLst.add(emp);
						break;
					}
					case 0:
						break;
					default:
						System.out.println("Wrong choice entered!!!");
					}

				} while (empType != 0);
				break;
			}
			case 2: {
				double salEmpPayroll = 0;
				double hryEmpPayroll = 0;
				double cmsEmpPayroll = 0;
				double bsEmpPayroll = 0;
				for (EmployeeInterface obj : empLst) {
					if (obj.getEmpTypeCode().equals(EmployeeType.SalariedEmp.getEmpTypeCode())) {
						salEmpPayroll += obj.empPayroll();
					} else if (obj.getEmpTypeCode().equals(EmployeeType.HourlyEmp.getEmpTypeCode())) {
						hryEmpPayroll += obj.empPayroll();
					} else if (obj.getEmpTypeCode().equals(EmployeeType.CommissionedEmp.getEmpTypeCode())) {
						cmsEmpPayroll += obj.empPayroll();
					} else if (obj.getEmpTypeCode().equals(EmployeeType.BaseSalariedEmp.getEmpTypeCode())) {
						bsEmpPayroll += obj.empPayroll();
					}
				}
				System.out.println();
				System.out.println("Weekly Pyroll for Salaried employees - " + salEmpPayroll);
				System.out.println("Weekly Pyroll for Hourly employees - " + hryEmpPayroll);
				System.out.println("Weekly Pyroll for Commissioned employees - " + cmsEmpPayroll);
				System.out.println("Weekly Pyroll for Base Salaried employees - " + bsEmpPayroll);
				System.out.println(
						"Total Weekly Pyroll - " + (salEmpPayroll + hryEmpPayroll + cmsEmpPayroll + bsEmpPayroll));
				break;
			}

			case 3: {
				int count = 1;
				for (EmployeeInterface obj : empLst) {
					System.out.println();
					System.out.println("Employee " + count);
					System.out.println("Employee Type - " + obj.printEmpType());
					System.out.println("Name - " + obj.getName());
					System.out.println("Email - " + obj.getEmail());
					System.out.println("Phone - " + obj.getPhone());
					if (obj.getEmpTypeCode().equals(EmployeeType.HourlyEmp.getEmpTypeCode())) {
						System.out.println("Hours Worked - " + ((HourlyEmployee) obj).getHoursWorked());
					} else if (obj.getEmpTypeCode().equals(EmployeeType.CommissionedEmp.getEmpTypeCode())) {
						System.out.println("Hours Worked - " + ((CommissionedEmployee) obj).getTotalSales());
					} else if (obj.getEmpTypeCode().equals(EmployeeType.BaseSalariedEmp.getEmpTypeCode())) {
						System.out.println("Hours Worked - " + ((BaseSalariedEmployee) obj).getTotalSales());
					}
					count++;
				}
				break;
			}
			case 0:
				System.out.println();
				System.out.println("--------- Program Exited ---------");
				break;
			default:
				System.out.println("Wrong choice entered!!!");
			}

		} while (mmChoice != 0);
		scan.close();
	}
}
