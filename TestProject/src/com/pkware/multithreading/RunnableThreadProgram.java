package com.pkware.multithreading;

class Thread1 implements Runnable{
	
	static Thread thread1;
	
	Thread1(){
		thread1 = new Thread(this,"Thread 1");
		System.out.println("Child Thread "+thread1);
		thread1.start();
	}
	
	@Override
	public void run() {
		try {
			for(int i=0;i<5;i++) {
				System.out.println(thread1.getName()+" iteration - "+(i+1));
				Thread.sleep(500);
			}
		}catch (InterruptedException e) {
			System.out.println("Thread 1 interuptted");
		}
		System.out.println("Thread 1 exiting - "+thread1.getState());
	}
	
	static void getThreadState() {
		System.out.println("Thread 1 state after run method is completed - "+thread1.getState());
	}
}

public class RunnableThreadProgram {
	public static void main(String[] args) {
		new Thread1();
		
		Thread currThread = Thread.currentThread();
		
		try {
			for(int i=0;i<5;i++) {
				System.out.println(currThread.getName()+" iteration - "+(i+1));
				Thread.sleep(500);
			}
		}catch (InterruptedException e) {
			System.out.println(currThread.getName()+" interuptted");
		}
		System.out.println(currThread.getName()+" exiting");	
		System.out.println(currThread.getName()+" "+currThread.getState());
		
		Thread1.getThreadState();
	}
	
}
