package practice;

import java.util.Scanner;

class Stack {
	private int st[];
	private int top;
	private int size;

	public Stack(int size) {
		this.size = size;
		st = new int[size];
		top = -1;
	}

	void push(int val) {
		st[++top] = val;
	}

	void pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			return;
		}
		int x = st[top--];
		System.out.println("Popped Element: " + x);
	}

	void display() {
		if (top == -1) {
			System.out.println("Stack is Empty");
			return;
		}

		for (int i = 0; i <= top; i++) {
			System.out.println("Element " + (i + 1) + " : " + st[i]);
		}
		System.out.println();
	}

	boolean isEmpty() {
		return top == -1;
	}

	boolean isFull() {
		return top == size - 1;
	}

	void peek() {
		if (isEmpty()) {
			System.out.println("Empty Stack");
		} else
			System.out.println("Element on top: " + st[top]);
	}

}

public class StackProgram {

	public static void main(String[] args) {
		System.out.println("------ Stack Program ------");
		Scanner scan = new Scanner(System.in);
		int size;
		System.out.print("Enter max size for the stack : ");
		size = scan.nextInt();

		Stack st = new Stack(size);
		int choice = -1;

		do {
			System.out.println();
			System.out.println("Enter 1 to insert an element");
			System.out.println("Enter 2 to pop element");
			System.out.println("Enter 3 to peek");
			System.out.println("Enter 4 to check empty stack");
			System.out.println("Enter 5 to display all elements");
			System.out.println("Enter 6 to exit");
			System.out.print("Enter Choice : ");
			boolean again = true;
			while (again) {
				try {
					choice = scan.nextInt();
					again = false;
				} catch (Exception e) {
					scan.next();
					System.out.println("Wrong Value Entered!!!");
					System.out.print("Enter Choice Again: ");
				}
			}
			System.out.println();

			switch (choice) {
			case 1:
				System.out.print("Enter Value to insert : ");
				if (!st.isFull()) {
					int val;
					try {
						val = scan.nextInt();
					} catch (Exception e) {
						scan.next();
						System.out.println("Wrong Value Entered!!!");
						break;
					}
					st.push(val);
				} else
					System.out.println("Stack Overflow");
				break;
			case 2:
				st.pop();
				break;
			case 3:
				st.peek();
				break;
			case 4:
				System.out.println("Stack Empty: " + st.isEmpty());
				break;
			case 5:
				st.display();
				break;
			case 6:
				System.out.println("----Program Exited----");
				break;
			default:
				System.out.println("Wrong choice");
			}
		} while (choice != 6);
		scan.close();
	}
}
