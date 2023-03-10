package com.pkware.collectionsframework.queueinterface;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayDequeueProgram {

	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<>();
		for(int i=0;i<5;i++) {
			lst.add(i);
		}
		
		//addFirst,offerFirst
		ArrayDeque<Integer> arrDq = new ArrayDeque<>(lst);
		for(int i=5;i<9;i++) {
			arrDq.addFirst(i);
		}
		
		//add,addLast,offerLast
		arrDq.offerLast(12);
		
		System.out.println("Initial dequeue - "+arrDq);
		
		//element method;
		System.out.println("Element at head of dq - "+arrDq.element());
		
		// getFirst, peekFirst
		System.out.println("Element at head - "+arrDq.peekFirst());
		
		// getLast, peekLast
		System.out.println("Element at head - "+arrDq.getLast());
		
		//contains method
		System.out.println("Dq contains 43 - "+arrDq.contains(43));
		
		//iterator
		Iterator<Integer> itr = arrDq.iterator();
		System.out.print("Iterating dequeue - ");
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		System.out.println();
		
		//descending iterator
		Iterator<Integer> dscItr = arrDq.descendingIterator();
		System.out.print("Iterating dequeue backwards - ");
		while(dscItr.hasNext()) {
			System.out.print(dscItr.next()+" ");
		}
		System.out.println();
		
		//poll method;
		System.out.println("Element polled - "+arrDq.poll());
		
		
		//remove methods
		//remove, poll, removeFirst,pollFirst
		System.out.println("Removing head - "+arrDq.removeFirst());
		
		//removeLast,pollLast
		System.out.println("Removing from last - "+arrDq.pollLast());
		
		
		//containsAll
		List<Integer> lst1 = new ArrayList<>();
		lst1.add(1);
		lst1.add(0);
		lst1.add(2);
		System.out.println("Dq contains all elements of lst1 - "+arrDq.containsAll(lst1));
		
		//clearing dequeue
		arrDq.clear();
		System.out.println("After clearing - "+arrDq);		
		
		//isEmpty
		System.out.println("Is dequeue empty - "+arrDq.isEmpty());
	}

}
