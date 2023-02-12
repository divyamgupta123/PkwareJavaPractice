package com.pkware.collectionsframework.setinterface;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetProgram {
	public static void main(String[] args) {
		LinkedHashSet<String> lkdHashSet = new LinkedHashSet<>();
		
		//add operation
		for(int i=111;i<119;i++) {
			lkdHashSet.add(String.valueOf(i));
		}
		System.out.println("Linked hash set after adding values - "+lkdHashSet);
		
		//remove 
		lkdHashSet.remove("115");
		System.out.println("After removing 115 - "+lkdHashSet);
		
		//iteration
		 System.out.print("Iterating using iterator - ");
		 
		 Iterator<String> itr = lkdHashSet.iterator();
		 while(itr.hasNext()) {
			 System.out.print(itr.next()+" ");
		 }
		 System.out.println();
		 
		 System.out.print("Iteration using enhanced for loop - ");
		 for(String i:lkdHashSet) {
			 System.out.print(i+" ");
		 }
		 System.out.println();

		 //size
		 System.out.println("Size of hash set - "+lkdHashSet.size());
		 
		 //isEmpty
		 lkdHashSet.clear();
		 System.out.println("is hash set empty - "+lkdHashSet.isEmpty());
		 
	}
}
