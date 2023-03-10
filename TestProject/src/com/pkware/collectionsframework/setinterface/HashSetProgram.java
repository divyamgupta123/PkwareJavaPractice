package com.pkware.collectionsframework.setinterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HashSetProgram {

	public static void main(String[] args) {
		/*
		This class permits the null element. 
		The class also offers constant time performance for the basic operations 
		like add, remove, contains, and size assuming the hash function disperses 
		the elements properly among the buckets,
		*/
		
		 HashSet<Integer> hashSet = new HashSet<>();
		 
		 //add operation
		 for(int i=0;i<5;i++) {
			 hashSet.add(i);
			 hashSet.add(i);
		 }
		 
		 List<Integer> lst = new ArrayList<>();
		 lst.add(0);
		 lst.add(1);
		 lst.add(2);
		 lst.add(5);
		 lst.add(4);
		 lst.add(6);
		 
		 hashSet.addAll(lst);
		 System.out.println("Hash Set after adding elements - "+hashSet);
		 
		 //remove operation
		 hashSet.remove(0);
		 System.out.println("After removing 0 - "+hashSet);
		 
		 System.out.println("Remove 9 - "+hashSet.remove(9));
		 
		 // contains
		 System.out.println("Hash set contains 5 - "+hashSet.contains(5));
		 System.out.println("Hash set contains 9 - "+hashSet.contains(9));
		 
		 //iteration
		 System.out.print("Iterating using iterator - ");
		 
		 Iterator<Integer> itr = hashSet.iterator();
		 while(itr.hasNext()) {
			 System.out.print(itr.next()+" ");
		 }
		 System.out.println();
		 
		 System.out.print("Iteration using enhanced for loop - ");
		 for(Integer i:hashSet) {
			 System.out.print(i+" ");
		 }
		 System.out.println();
		 
		 //remove if
		 hashSet.removeIf(n->(n<3));
		 System.out.println("After remove if operation - "+hashSet);
		 
		 //size
		 System.out.println("Size of hash set - "+hashSet.size());
		 
		 //isEmpty
		 System.out.println("is hash set empty - "+hashSet.isEmpty());
		 
		 //union operation
		 hashSet.addAll(lst);
		 System.out.println("Union with list - "+hashSet);
		 
		 //add operation
		 for(int i=0;i<5;i++) {
			 hashSet.add(i);
			 hashSet.add(i);
		 }
		 
		 //intersection
		 hashSet.retainAll(lst);
		 System.out.println("Intersection with list - "+hashSet);
		 
		 //add operation
		 for(int i=0;i<5;i++) {
			 hashSet.add(i);
			 hashSet.add(i);
		 }
		 
		 //difference
		 hashSet.removeAll(lst);
		 System.out.println("Difference with list - "+hashSet);
	}
}
