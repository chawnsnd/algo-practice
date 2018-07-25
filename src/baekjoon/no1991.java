package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class no1991 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		String[] rootTmp = scanner.nextLine().split(" ");
		TreeNode root = new TreeNode();
		root.parent = null;
		root.data = rootTmp[0];
		makeTree(root, scanner);
	}
	
	static void makeTree(TreeNode parent, Scanner scanner) {
		//자식만들기
		String[] nodeTmp = scanner.nextLine().split(" ");
		if(nodeTmp[0].equals(parent.Children.get(0)) || nodeTmp[0].equals(parent.Children.get(1))) {
			TreeNode leftChild = null;
			TreeNode rightChild = null;
			if(!nodeTmp[1].equals(".")) {
				leftChild = new TreeNode();
				leftChild.data = nodeTmp[1];
				makeTree(leftChild, scanner);
			}
			if(!nodeTmp[2].equals(".")) {
				rightChild = new TreeNode();
				rightChild.data = nodeTmp[2];
				makeTree(rightChild, scanner);
			}
		}
	}
	
	static class TreeNode{
		TreeNode parent;
		String data;
		ArrayList<TreeNode> Children;
	}
}
