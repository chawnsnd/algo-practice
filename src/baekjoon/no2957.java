package baekjoon;

import java.util.Scanner;

public class no2957 {
	
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		int[] counts = new int[N];
		counts[0] = 0;
		int rootNumber = Integer.parseInt(scanner.nextLine());
		Tree tree = new Tree(rootNumber);
		for(int i=1; i<N; i++) {
			int insertNumber = Integer.parseInt(scanner.nextLine());
			tree.insert(insertNumber, tree.root);
			counts[i] = count;
		}
		
		scanner.close();
		for(int count : counts)
			System.out.println(count);
	}
	
	
	static class TreeNode{
		int number;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int number){
			this.number = number;
		}
	}
	
	static class Tree{
		TreeNode root;
		
		Tree(int number){
			root = new TreeNode(number);
		}
		
		void insert(int number, TreeNode node) {
			count++;
			if(node.number > number) {
				if(node.left == null) {
					node.left = new TreeNode(number);
				}else {
					insert(number, node.left);
				}
			}else {
				if(node.right == null) {
					node.right = new TreeNode(number);
				}else {
					insert(number, node.right);
				}
			}
		}
		
	}
}
