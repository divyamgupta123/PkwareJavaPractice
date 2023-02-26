package com.pkware.multithreading;

class ThreadGroupHelper implements Runnable {

	Thread t;
	private String name;
	
	public ThreadGroupHelper(ThreadGroup tg,String name) {
		this.name = name;
		t = new Thread(tg,this,name);
		t.start();
	}
	
	@Override
	public void run() {
		System.out.println("Thread name - "+name);
		System.out.println("Thread "+name+" group - "+t.getThreadGroup());
	}
	
}

public class ThreadGroupPractice {

	public static void main(String[] args) {
		
		ThreadGroup threadGroup = new ThreadGroup("TG 1");
		
		ThreadGroupHelper obj1 = new ThreadGroupHelper(threadGroup,"One");
		ThreadGroupHelper obj2 = new ThreadGroupHelper(threadGroup,"Two");
		ThreadGroupHelper obj3 = new ThreadGroupHelper(threadGroup,"Three");
		ThreadGroupHelper obj4 = new ThreadGroupHelper(threadGroup,"Four");
		
		obj2.t.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println();
		threadGroup.list();
		
		System.out.println("Is thread group deamon - "+threadGroup.isDaemon());
		System.out.println("Is thread group destroyed - "+threadGroup.isDestroyed());
		System.out.println("Active Threads in Group - "+threadGroup.activeCount());
		System.out.println("Maximum thread priority in the Group - "+threadGroup.getMaxPriority());
		try {
			obj1.t.join();
			obj2.t.join();
			obj3.t.join();
			obj4.t.join();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		threadGroup.destroy();
		System.out.println("Number of Active Thread Groups - "+threadGroup.activeGroupCount());
		
	}

}
