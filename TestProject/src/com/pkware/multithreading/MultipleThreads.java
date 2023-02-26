package com.pkware.multithreading;

class Threads implements Runnable{

	String name;
	Thread t;
	
	Threads(String name){
		this.name = name;
		t = new Thread(this,name);
		System.out.println("New Thread with name -"+name+" created");
		System.out.println(name+" State before start method called - "+t.getState());
		t.start();
		System.out.println(name+" State after start method called - "+t.getState());
	}
	
	
	@Override
	public void run() {
		try {
			for(int i=1;i<=4;i++) {
				System.out.println(this.name+" iteration - "+i+". State - "+t.getState());
				Thread.sleep(400);
			}
		}catch(InterruptedException e) {
			System.out.println("Thread Interupted");
		}
		System.out.println("Thread "+this.name+" completed");
	}
	
}

public class MultipleThreads {

	public static void main(String[] args) {
		new Threads("Thread 1");
		new Threads("Thread 2");
		new Threads("Thread 3");
		
		try {
			Thread.sleep(5000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" exited");
	}

}
