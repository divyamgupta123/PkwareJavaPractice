package com.pkware.multithreading;

class Thread3 implements Runnable {
	@Override
	public void run() {
		System.out.println();
		System.out.println("Thread 3 run called");
		System.out.println("Thread 3 made by implementing Runnable called");
		
		for(int i=0;i<5;i++) {
			try {
				System.out.println("Thread 3 loop iteration - "+i);
				Thread.sleep(1000);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

class Thread2 extends Thread {
	@Override
	public void run() {
		System.out.println();
		System.out.println("Thread 2 run called");
		System.out.println("Thread 2 made by extending Thread called");
		
		for(int i=0;i<5;i++) {
			try {
				System.out.println("Thread 2 loop iteration - "+i);
				Thread.sleep(1000);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

public class NewThreadProgram {

	public static void main(String[] args) {
		Thread thread1 = new Thread("Thread 1");

		thread1.start();

		System.out.println("State of Thread 1 - " + thread1.getState());
		System.out.println();

		Thread2 thread2 = new Thread2();
		thread2.start();
		
		Thread3 th3 = new Thread3();
		Thread thread3 = new Thread(th3);
		thread3.start();
		
	}

}
