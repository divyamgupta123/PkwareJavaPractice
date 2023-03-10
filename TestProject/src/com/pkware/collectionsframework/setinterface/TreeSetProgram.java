package com.pkware.collectionsframework.setinterface;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetProgram {

	public static void main(String[] args) {
		TreeSet<Integer> trSet = new TreeSet<>();
		
		trSet.add(0);
		trSet.add(1);
		trSet.add(5);
		trSet.add(8);
		trSet.add(3);
		trSet.add(4);
		trSet.add(0);
		trSet.add(2);
		trSet.add(11);
		trSet.add(9);
		
		System.out.println("Initial Tree Set - "+trSet);
		
		
		//contains , first, last
		System.out.println("TreeSet contains 9 - "+trSet.contains(9));
		System.out.println("First element - "+trSet.first());
		System.out.println("Last element - "+trSet.last());
		
		//higher, lower
		System.out.println("Element higher than 6 - "+trSet.higher(6));
		System.out.println("Element lower than 6 - "+trSet.lower(6));
		
		//remove 
		trSet.remove(8);
		System.out.println("After removing 8 - "+trSet);
		
		//pollFirst, pollLast
		System.out.println("First element removed - "+trSet.pollFirst());
		System.out.println("Last element removed - "+trSet.pollLast());
		
		//iterators
		Iterator<Integer> itr = trSet.iterator();
		System.out.print("Iterating using iterator - ");
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		System.out.println();
		
		//descending iterator
		Iterator<Integer> dscItr = trSet.descendingIterator();
		System.out.print("Iterating using descending iterator - ");
		while(dscItr.hasNext()) {
			System.out.print(dscItr.next()+" ");
		}
		System.out.println();
		
		// subset
		System.out.println("Subset ranging from 2 to 5 - "+trSet.subSet(2, 6));
		
		//tailSet
		System.out.println("Elements greater than or equal to 3 - "+trSet.tailSet(3));
		
		//headSet
		System.out.println("Elements less than or equal to 3 - "+trSet.headSet(3));
		
		//descending set
		System.out.println("Set in reverse order - "+trSet.descendingSet());
		
		//size
		System.out.println("Size of set - "+trSet.size());
		
		//clear
		trSet.clear();
		System.out.println("After clearing set - "+trSet);
		
	}

}
