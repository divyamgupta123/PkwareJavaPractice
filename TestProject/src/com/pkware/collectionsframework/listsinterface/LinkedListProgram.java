package com.pkware.collectionsframework.listsinterface;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListProgram {
	public static void main(String[] args) {
		LinkedList<Integer> lkdLst = new LinkedList<>();
		LinkedList<Integer> tmpList = new LinkedList<>();
		// add operation
		for(int i=1;i<=4;i++) {
			lkdLst.add(i*10);
		}
		
		tmpList.add(70);
		tmpList.add(60);
		tmpList.add(50);
		
		lkdLst.addAll(3,tmpList);
		
		lkdLst.addFirst(100);
		lkdLst.addLast(500);
		
		System.out.println("Linked list after adding elements - "+lkdLst);
		
		//set operation
		ListIterator<Integer> lstItr = lkdLst.listIterator();
		while(lstItr.hasNext()) {
			Integer x = lstItr.next();
			lstItr.set(x/2);
		}
		System.out.println("After chnaging elements - "+lkdLst);
		
		
		//size operation 
		System.out.println("Size of list - "+lkdLst.size());
		
		//remove operations
		lkdLst.remove();
		System.out.println("Removing head of list - "+lkdLst);
		
		lkdLst.remove(Integer.valueOf(25));
		System.out.println("Removing value 25 in list - "+lkdLst);
		
		lkdLst.removeFirst();
		lkdLst.removeLast();
		System.out.println("Removing first and last element - "+lkdLst);
		
		//clearing list 
		lkdLst.clear();
		System.out.println("After clearing list - "+lkdLst);
		
		
		// poll vs remove - poll handles empty list;
		// similar for peek and get - peek handles empty list
		System.out.println("Removing using poll function - ");
		lkdLst.pollLast();
		try {
			System.out.println("Removing using remove function - ");
			lkdLst.removeLast();
		}
		catch (Exception e) {
			System.out.println("Remove throws exception on empty list");
		}
		
	}
}
