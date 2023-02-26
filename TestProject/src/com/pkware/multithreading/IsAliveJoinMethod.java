package com.pkware.multithreading;

public class IsAliveJoinMethod {
	public static void main(String[] args) {
		Threads thread1 = new Threads("Thread 1");
		Threads thread2 = new Threads("Thread 2");
		Threads thread3 = new Threads("Thread 3");
	
		System.out.println("Thread 1 is alive - "+thread1.t.isAlive());
		System.out.println("Thread 2 is alive - "+thread2.t.isAlive());
		System.out.println("Thread 3 is alive - "+thread3.t.isAlive());
		
		try {
			System.out.println("Waiting for child threads to finish");
			thread1.t.join();
			thread2.t.join();
			thread3.t.join();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread 1 is alive - "+thread1.t.isAlive());
		System.out.println("Thread 2 is alive - "+thread2.t.isAlive());
		System.out.println("Thread 3 is alive - "+thread3.t.isAlive());
		
		System.out.println("Main thread exiting");
	}
}
