package com.pkware.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable{

	private String msg;
	public WorkerThread(String msg) {
		this.msg = msg;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" (Start) message - "+this.msg);
		processMessage();
		System.out.println(Thread.currentThread().getName()+" (End)");
		
	}

	private void processMessage() {
		try {
			Thread.sleep(1000);
		}catch (Exception e) {
		}
		
	}
	
}

public class ThreadPoolPractice {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for(int i=1;i<=10;i++) {
			Runnable worker = new WorkerThread(String.valueOf(i));
			executor.execute(worker);
		}
		executor.shutdown();
		while(!executor.isTerminated()) {}
		
		System.out.println("Finished all Threads");
	}
}
