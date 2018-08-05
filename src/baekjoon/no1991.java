package baekjoon;

import java.util.Scanner;

public class no1991 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		String[] data = scanner.nextLine().split(" ");
		
		Tree tree = new Tree(data[0].charAt(0), data[1].charAt(0), data[2].charAt(0));
		
		for(int i=1; i<N; i++) {
			data = scanner.nextLine().split(" ");
			tree.add(data[0].charAt(0), data[1].charAt(0), data[2].charAt(0));
		}
		
		scanner.close();
		
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
	}
	
	
	static class TreeNode{
		char data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(char data){
			this.data = data;
		}
	}
	
	static class Tree{
		TreeNode root;
		
		Tree(char data, char left, char right){
			root = new TreeNode(data);
			if(data != '.') root = new TreeNode(data);
			if(left != '.') root.left = new TreeNode(left);
			if(right != '.') root.right = new TreeNode(right);
		}
		
		void add(char data, char left, char right) {
			next(root.left, data, left, right);
			next(root.right, data, left, right);
		}
		
		void next(TreeNode node, char data, char left, char right) {
			if(node==null) return;
			if(node.data == data) {
				if(left != '.') node.left = new TreeNode(left);
				if(right != '.') node.right = new TreeNode(right);
			}else {
				next(node.left, data, left, right);
				next(node.right, data, left, right);
			}
		}
		
		//전위 순회
		void preOrder(TreeNode node) {
			System.out.print(node.data);
			if(node.left != null) preOrder(node.left);
			if(node.right != null) preOrder(node.right);
		}
		//중위 순회
		void inOrder(TreeNode node) {
			if(node.left != null) inOrder(node.left);
			System.out.print(node.data);
			if(node.right != null) inOrder(node.right);
		}
		//후위 순회
		void postOrder(TreeNode node) {
			if(node.left != null) postOrder(node.left);
			if(node.right != null) postOrder(node.right);
			System.out.print(node.data);
		}
	}
}
