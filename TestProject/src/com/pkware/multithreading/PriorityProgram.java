package com.pkware.multithreading;

class Clicker implements Runnable{

	long click = 0;
	Thread t;
	private volatile boolean running = true;
	
	public Clicker(int p) {
		t = new Thread(this);
		t.setPriority(p);
	}
	
	@Override
	public void run() {
		while(running) {
			click++;
		}
	}
	
	public void stop() {
		running = false;
	}
	
	public void start() {
		t.start();
	}
}

public class PriorityProgram {
	public static void main(String[] args) {
		Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
		Clicker obj1 = new Clicker(Thread.MIN_PRIORITY+1);
		Clicker obj2 = new Clicker(Thread.MIN_PRIORITY+2);
		Clicker obj3 = new Clicker(Thread.MIN_PRIORITY+3);
		Clicker obj4 = new Clicker(Thread.MIN_PRIORITY+4);
		Clicker obj5 = new Clicker(Thread.MIN_PRIORITY+5);
		Clicker obj6 = new Clicker(Thread.MIN_PRIORITY+6);
		
		obj1.start();
		obj2.start();
		obj3.start();
		obj4.start();
		obj5.start();
		obj6.start();
		
		try {
			Thread.sleep(3000);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		obj1.stop();
		obj2.stop();
		obj3.stop();
		obj4.stop();
		obj5.stop();
		obj6.stop();
		
		try {
			obj1.t.join();
			obj2.t.join();
			obj3.t.join();
			obj4.t.join();
			obj5.t.join();
			obj6.t.join();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Low priority thread clicks - "+obj1.click);
		System.out.println("Low priority thread clicks - "+obj2.click);
		System.out.println("Low priority thread clicks - "+obj3.click);
		System.out.println("Low priority thread clicks - "+obj4.click);
		System.out.println("Low priority thread clicks - "+obj5.click);
		System.out.println("Low priority thread clicks - "+obj6.click);
	}
}
