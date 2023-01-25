package practice;

class BTNode{
	int data;
	BTNode left,right;
	
	BTNode(int data){
		this.data = data;
		left = null;
		right = null;
	}
}

class BinaryTree{
	BTNode root;
	
	BinaryTree(){
		root = null;
	}
	
	void inorder(BTNode root) {
		if(root == null) return;
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	void preorder(BTNode root) {
		if(root == null) return;
		
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	void postorder(BTNode root) {
		if(root == null) return;
		
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}
}

public class BinaryTreeProgram {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new BTNode(1);
		bt.root.right = new BTNode(2);
		bt.root.left = new BTNode(3);
		
		bt.root.right.right = new BTNode(4);
		bt.root.right.left = new BTNode(5);
		
		bt.root.left.right = new BTNode(6);
		bt.root.left.left = new BTNode(7);
		
		System.out.println("Inorder Taversal");
		bt.inorder(bt.root);
		System.out.println();
		
		System.out.println("Preorder Taversal");
		bt.preorder(bt.root);
		System.out.println();
		
		System.out.println("Postorder Taversal");
		bt.postorder(bt.root);
	}

}
