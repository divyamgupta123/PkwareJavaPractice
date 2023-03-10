package com.pkware.collectionsframework.listsinterface;

import java.util.ListIterator;
import java.util.Vector;

public class VectorProgram {

	public static void main(String[] args) {
		Vector<Integer> vct = new Vector<>(2,2);
		
		System.out.println("Initial Capacity - "+vct.capacity());
		System.out.println("Initial size - "+vct.size());
		
		
		//adding elements
		for(int i=1;i<=7;i++) {
			vct.add(i*i);
			System.out.println("Capacity after "+i+" elements - "+vct.capacity());
			System.out.println("Size after "+i+" elements - "+vct.size());
		}
		
		System.out.println("Final Vector - "+vct);
		
		//changing elements 
		vct.set(2, 20);
		System.out.println("Vector after changing element - "+vct);
		
		//removing elements
		vct.remove(vct.size()-2);
		vct.remove(Integer.valueOf(1));
		System.out.println("Vector after removing element - "+vct);
		
		// contains method
		System.out.println("Vector contains 5 - "+vct.contains(5));
		
		//index of method
		System.out.println("Index of 49 in vector - "+vct.indexOf(49));
		
		
		//trim to size
		System.out.println();
		System.out.println("Capacity before trimming - "+vct.capacity());
		System.out.println("Size before trimming - "+vct.size());
		vct.trimToSize();
		System.out.println("Capacity after trimming - "+vct.capacity());
		System.out.println("Size after trimming - "+vct.size());
		System.out.println();
		
		//list iterator
		ListIterator<Integer> lstItr = vct.listIterator(vct.size());
		System.out.print("Iterating backwards using list iterator - ");
		while(lstItr.hasPrevious()) {
			System.out.print(lstItr.previous()+" ");
		}
		System.out.println();
		
		//to string
		System.out.println("Vector to String - "+vct.toString());
		
		//clearing vector
		vct.clear();
		System.out.println("Vector after clearing - "+vct);
	}
}
