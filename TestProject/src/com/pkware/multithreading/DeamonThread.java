package com.pkware.multithreading;

class DeamonHelper implements Runnable{
	
	Thread t;
	public DeamonHelper(String name) {
		t = new Thread(this,name);
	}
	
	@Override
	public void run() {
		if(Thread.currentThread().isDaemon()) {
			System.out.println(Thread.currentThread().getName()+" is a Deamon thread");
		}else {	
			System.out.println(Thread.currentThread().getName()+" is a user thread");
		}
	}
}

public class DeamonThread {

	public static void main(String[] args) {
		DeamonHelper obj1 = new DeamonHelper("Thread 1");
		DeamonHelper obj2 = new DeamonHelper("Thread 2");
		DeamonHelper obj3 = new DeamonHelper("Thread 3");
		
		obj2.t.setDaemon(true);
		
		obj1.t.start();
		obj2.t.start();
		obj3.t.start();
	}

}
