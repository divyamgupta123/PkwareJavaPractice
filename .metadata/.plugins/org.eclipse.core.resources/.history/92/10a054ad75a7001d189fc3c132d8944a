package com.pkware.collectionsframework.listsinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListProgram implements Cloneable {
	public static void main(String[] args) {
		//initializing array list
		ArrayList<Integer> lst = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		
		System.out.println("Initial size of Array List - "+lst.size());
		
		//adding elements
		for(int i=0;i<4;i++) {
			lst.add(i+1);
		}
		
		lst.add(4,5);
		
		tmp.add(6);
		tmp.add(7);
		
		lst.addAll(5,tmp);
		
		System.out.println("Array list after adding elements - "+lst);
		
		//changing elements;
		for(int i=0;i<lst.size();i++) {
			lst.set(i, (i+1)*(i+1));
		}
		
		System.out.println("Array list after changing elements - "+lst);
		
		//removing elements
		lst.remove(lst.size()-1); //index as parameter
		lst.remove(new Integer(4)); //object as a parameter
		System.out.println("Array list after removing elements - "+lst);
		
		ArrayList<Integer> tmpLst = (ArrayList<Integer>)lst.clone();
		System.out.println("New Cloned List - "+tmpLst);
		
		
		tmpLst.set(1, 100);
//		tmpLst = (ArrayList<Integer>)tmp;
		System.out.println("After changing element in cloned list - "+tmpLst);
		System.out.println("Original List after changing element in cloned list - "+lst);
		
		//Contains method
		System.out.println("Array list contains 16 - "+lst.contains(16));
		System.out.println("Array list contains 11 - "+lst.contains(11));
		
		//isEmpty 
		System.out.println("Array list is empty - "+lst.isEmpty());
		
		//removeif 
		lst.removeIf(n->(n%2==0));
		System.out.println("List after remove if - "+lst);
		
		
		// list iterator
		ListIterator<Integer> lstItr = lst.listIterator();
		System.out.print("Iterating list with list iterator - ");
		while(lstItr.hasNext()) {
			System.out.print(lstItr.next() + " ");
		}
		System.out.println();
		
		//clearing array list
		lst.clear();
		System.out.println("Array list after clearing - "+lst);
		
		
	}
}
