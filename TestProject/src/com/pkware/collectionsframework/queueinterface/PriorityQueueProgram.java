package com.pkware.collectionsframework.queueinterface;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueProgram {
	public static void main(String[] args) {
		//smallest element at head;
		Queue<Integer> prQueue = new PriorityQueue<>();
		
		prQueue.add(10);
		prQueue.add(1);
		prQueue.add(5);
		prQueue.add(30);
		prQueue.add(12);
		
		System.out.println("Priority Queue after adding elements - "+prQueue);
		
		//peek operation
		System.out.println("Element at head - "+prQueue.peek());
		
		//poll operation
		for(int i=0;i<2;i++) {
			System.out.println("Element removed - "+prQueue.poll());
		}
		System.out.println("Priority Queue after removing elements - "+prQueue);
		
		//remove operation 
		prQueue.remove(Integer.valueOf(12));
		System.out.println("Priority Queue after removing elements - "+prQueue);
		
		//iterating queue
		Iterator<Integer> itr = prQueue.iterator();
		System.out.print("Iterating using iterator - ");
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		System.out.println();
		
		//size
		System.out.println("Size of queue - "+prQueue.size());
		
		//isEmpty
		System.out.println("Is queue empty - "+prQueue.isEmpty());
		
		//remove if
		prQueue.removeIf(x->(x<30&&x>9));
		System.out.println("After remove if operation - "+prQueue.toString());
		
		//clearing queue
		prQueue.clear();
		System.out.println("Priority Queue after clearing - "+prQueue);
		
	}
}