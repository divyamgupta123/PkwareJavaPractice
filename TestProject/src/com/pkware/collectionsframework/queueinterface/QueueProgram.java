package com.pkware.collectionsframework.queueinterface;

import java.util.LinkedList;
import java.util.Queue;

public class QueueProgram {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		//add method
		for(int i=1;i<=7;i++) {
			queue.add(i);
		}
		
		System.out.println("Queue after adding elements - "+queue);
		
		//remove elements - Retrieves and removes the head of this queue. This method differsfrom poll() only in that it throws an exception ifthis queue is empty.
		System.out.println("Removed head of queue - "+queue.remove());
		queue.remove(Integer.valueOf(5));
		System.out.println("Queue after removing 5 - "+queue);
		
		//set operation
		for(int i=0;i<queue.size();i++) {
			Integer x = queue.poll();
			queue.add(x*10);
		}
		System.out.println("After changing elements - "+queue);
		
		//size
		System.out.println("Size of queue - "+queue.size());
		
		//is empty
		System.out.println("Is queue empty - "+queue.isEmpty());
		
		//clearing queue
		queue.clear();
		System.out.println("After clearing queue - "+queue);
		
		//poll operation
		queue.poll();
		System.out.println("Poll operation works of empty collection");
		
	
	}

}
