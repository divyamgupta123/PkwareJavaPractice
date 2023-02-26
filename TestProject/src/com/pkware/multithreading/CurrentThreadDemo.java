package com.pkware.multithreading;

public class CurrentThreadDemo {

	public static void main(String[] args) {
		Thread currThread = Thread.currentThread();
		System.out.println("Current thread details - "+currThread);
		System.out.println("Current Thread state - "+currThread.getState());
		
		currThread.setName("Main Thread");
		System.out.println("Current thread details after changing name - "+currThread);
		
		
		try {
			for(int i=0;i<7;i++) {
				System.out.println(i);
				Thread.sleep(500);
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Number of active thread - "+Thread.activeCount());
	}

}
