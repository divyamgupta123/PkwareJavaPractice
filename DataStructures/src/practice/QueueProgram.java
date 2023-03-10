package practice;

import java.util.Scanner;

class Queue{
	private int size;
	private int[] queue;
	private int front;
	private int rear;
	
	Queue(int size){
		this.size = size;
		queue = new int[size];
		front = -1;
		rear = -1;
	}
	
	boolean isFull() {
		return rear == size-1;
	}
	
	boolean isEmpty() {
		if(front == -1 && rear == -1) return true;
		if(front > rear) {
			front = rear = -1;
			return true;
		}
		return false;
	}
	
	void enqueue(int val) {
		queue[++rear] = val;
	}
	
	void dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
		}else {
			if(front == -1) front = 0;
			System.out.println("Element removed : "+queue[front++]);
			if(front > rear) front = rear = -1;
		}
	}
	
	void display() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return;
		}
		int j=1;
		int i = front ==-1?0:front;
		for(;i<=rear;i++) {
			System.out.println("Element "+(j++)+" : "+queue[i]);
		}
		System.out.println();
	}
}

public class QueueProgram {

	public static void main(String[] args) {
		System.out.println("------ Queue Program ------");
		Scanner scan = new Scanner(System.in);
		int size;
		System.out.print("Enter max size for the queue : ");
		size = scan.nextInt();

		Queue queue = new Queue(size);
		int choice = -1;

		do {
			System.out.println();
			System.out.println("Enter 1 to insert an element");
			System.out.println("Enter 2 to delete an element");              
			System.out.println("Enter 3 to display all elements");
			System.out.println("Enter 4 to exit");
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
				if (!queue.isFull()) {
					int val;
					try {
						val = scan.nextInt();
					} catch (Exception e) {
						scan.next();
						System.out.println("Wrong Value Entered!!!");
						break;
					}
					queue.enqueue(val);
				} else
					System.out.println("Queue Overflow");
				break;
			case 2:
				queue.dequeue();
				break;
			case 3:
				queue.display();
				break;
			case 4:
				System.out.println("----Program Exited----");
				break;
			default:
				System.out.println("Wrong choice");
			}
		} while (choice != 4);
		scan.close();
	
	}
}
