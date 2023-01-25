package practice;

import java.util.Scanner;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	private Node head;

	LinkedList() {
		head = null;
	}

	void insertAtBeg(int val) {
		if (head == null) {
			head = new Node(val);
		} else {
			Node tmp = head;
			head = new Node(val);
			head.next = tmp;
		}
	}

	void insertAtEnd(int val) {
		if (head == null) {
			head = new Node(val);
			return;
		}
		Node tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = new Node(val);
	}

	void insertAtPos(int val, int pos) {
		if (pos > getLength()) {
			System.out.println("Position value is greater than length");
			return;
		}
		if (pos == 0) {
			System.out.println("Position shouls be greater than 1");
			return;
		}

		if (pos == 1) {
			insertAtBeg(val);
			return;
		}

		Node tmp = new Node(val);
		for (int i = 1; i < pos - 1; i++) {
			tmp = tmp.next;
		}

		Node tmp2 = tmp.next;

		tmp.next = new Node(val);
		tmp.next.next = tmp2;

	}

	void deleteAtPos(int pos) {
		if (pos > getLength()) {
			System.out.println("Position value is greater than length");
			return;
		}
		if (pos == 0) {
			System.out.println("Position shouls be greater than 1");
			return;
		}

		if (pos == 1) {
			head = head.next;
			return;
		}

		Node tmp = head;
		for (int i = 1; i < pos - 1; i++) {
			tmp = tmp.next;
		}

		System.out.println("Element deleted : " + tmp.next.data);

		if (tmp.next.next == null)
			tmp.next = null;
		else
			tmp.next = tmp.next.next;
	}

	int getLength() {
		int len = 0;
		Node tmp = head;
		while (tmp != null) {
			len++;
			tmp = tmp.next;
		}
		return len;
	}

	void reverseList() {
		if(getLength() == 0) {
			System.out.println("List is Empty!!!");
			return;
		}
		Node prev = null;
		Node nxt = null;
		Node tmp = head;

		while (tmp != null) {
			nxt = tmp.next;
			tmp.next = prev;
			prev = tmp;
			tmp = nxt;
		}
		head = prev;
	}

	void display() {
		int i = 1;
		Node tmp = head;
		while (tmp != null) {
			System.out.println("Element " + (i++) + " : " + tmp.data);
			tmp = tmp.next;
		}
		if(i==1) System.out.println("List is Empty!!!!");
	}
}

public class LinkedListProgram {
	public static void main(String[] args) {
		System.out.println("------ Linked List Program ------");
		Scanner scan = new Scanner(System.in);

		LinkedList ll = new LinkedList();
		int choice = -1;

		do {
			System.out.println();
			System.out.println("Enter 1 to insert an element at beginning");
			System.out.println("Enter 2 to insert an element at end");
			System.out.println("Enter 3 to insert an element at a position");
			System.out.println("Enter 4 to delete an element from a position");
			System.out.println("Enter 5 to reverse the list");
			System.out.println("Enter 6 to display all elements");
			System.out.println("Enter 7 to exit");
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
			int val, pos;
			switch (choice) {
			case 1:
			case 2:
				System.out.print("Enter Value to insert : ");

				try {
					val = scan.nextInt();
				} catch (Exception e) {
					scan.next();
					System.out.println("Wrong Value Entered!!!");
					break;
				}
				if (choice == 1)
					ll.insertAtBeg(val);
				if (choice == 2)
					ll.insertAtEnd(val);
				break;
			case 3:
				try {
					System.out.print("Enter Value to insert : ");
					val = scan.nextInt();
					System.out.print("Enter Position : ");
					pos = scan.nextInt();
				} catch (Exception e) {
					scan.next();
					System.out.println("Wrong Value Entered!!!");
					break;
				}
				ll.insertAtPos(val, pos);
				break;
			case 4:
				try {
					System.out.print("Enter Position : ");
					pos = scan.nextInt();
				} catch (Exception e) {
					scan.next();
					System.out.println("Wrong Value Entered!!!");
					break;
				}
				ll.deleteAtPos(pos);
				break;
			case 5:
				ll.reverseList();
				break;
			case 6:
				ll.display();
				break;
			case 7:
				System.out.println("------ Program Exited ------");
				break;
			default:
				System.out.println("Wrong choice");
			}
		} while (choice != 7);
		scan.close();
	}
}