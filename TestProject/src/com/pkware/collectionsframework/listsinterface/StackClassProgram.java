package com.pkware.collectionsframework.listsinterface;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class StackClassProgram {
	public static void main(String[] args) {
		Stack<String> st = new Stack<>();

		// push operation
		for (int i = 0; i < 5; i++) {
			st.push(String.valueOf(i));
		}
		System.out.println("Stack after adding elements - " + st);

		// peek operation
		System.out.println("Element at top - " + st.peek());

		// pop operation
		for (int i = 0; i < 2; i++) {
			st.pop();
		}

		System.out.println("Stack after popping elements - " + st);

		// is empty
		System.out.println("Is stack empty - " + st.empty());

		// search operation
		System.out.println("Position of 0 from top of stack - " + st.search("0"));

		// iterator
		Iterator<String> itr = st.iterator();
		System.out.print("Iteration using iterator - ");
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();

		// changing elements is easy by using list iterator
		ListIterator<String> lstItr = st.listIterator();
		while (lstItr.hasNext()) {
			String i = lstItr.next();
			lstItr.set(i + i);
		}
		System.out.println("After Changing elements is stack - " + st);

		Object strArr[] = st.toArray();
		System.out.print("String Arr - ");
		for (Object a : strArr) {
			System.out.print(a + " ");
		}
		System.out.println();

		// clearing stack
		st.clear();
		System.out.println("Stack after clearing - " + st);
	}
};