package practice;

import java.util.Scanner;

class BSTNode {
	int data;
	BSTNode left, right;

	BSTNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class BinarySearchTree {
	BSTNode root;

	public BinarySearchTree() {
		this.root = null;
	}

	static BSTNode insertNode(int data, BSTNode root) {
		if (root == null) {
			root = new BSTNode(data);
			return root;

		}
		if (root.data < data)
			root.right = insertNode(data, root.right);
		if (root.data > data)
			root.left = insertNode(data, root.left);

		return root;
	}

	static boolean searchNode(int data, BSTNode root) {
		if (root == null)
			return false;
		if (root.data == data)
			return true;

		if (root.data > data)
			return searchNode(data, root.left);
		return searchNode(data, root.right);
	}

	static BSTNode deleteNode(BSTNode root, int data) {
		if (root == null)
			return root;

		if (root.data > data)
			root.left = deleteNode(root.left, data);
		if (root.data < data)
			root.right = deleteNode(root.right, data);

		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			root.data = minValue(root.right);
			root.right = deleteNode(root.right, root.data);
		}
		return root;
	}

	static int minValue(BSTNode root) {
		int minV = root.data;
		while (root.left != null) {
			minV = root.left.data;
			root = root.left;
		}
		return minV;
	}

	static void inorder(BSTNode root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
}

public class BSTProgram {
	public static void main(String[] args) {
		System.out.println("------ Binary Search Tree Program ------");
		Scanner scan = new Scanner(System.in);

		BinarySearchTree bst = new BinarySearchTree();
		int choice = -1;

		do {
			System.out.println();
			System.out.println("Enter 1 to insert an element");
			System.out.println("Enter 2 to delete an element");
			System.out.println("Enter 3 to search the list");
			System.out.println("Enter 4 to traverse tree");
			System.out.println("Enter 5 to exit");
			System.out.println();
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

			int val;
			switch (choice) {
			case 1:
				System.out.print("Enter Value to insert : ");
				try {
					val = scan.nextInt();
				} catch (Exception e) {
					scan.next();
					System.out.println("Wrong Value Entered!!!");
					break;
				}
				bst.root = BinarySearchTree.insertNode(val, bst.root);
				break;
			case 2:
				System.out.print("Enter Value to delete : ");
				try {
					val = scan.nextInt();
				} catch (Exception e) {
					scan.next();
					System.out.println("Wrong Value Entered!!!");
					break;
				}
				BinarySearchTree.deleteNode(bst.root, val);
				break;
			case 3:
				System.out.print("Enter Value to search : ");
				try {
					val = scan.nextInt();
				} catch (Exception e) {
					scan.next();
					System.out.println("Wrong Value Entered!!!");
					break;
				}
				boolean isFound = BinarySearchTree.searchNode(val, bst.root);
				System.out.println("Value Found : " + isFound);
				break;
			case 4:
				BinarySearchTree.inorder(bst.root);
				break;
			case 5:
				System.out.println("------ Program Exited ------");
				break;
			default:
				System.out.println("Wrong choice");
			}
		} while (choice != 5);
		scan.close();

	}
}
