package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class no1915 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] nm = scanner.nextLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		int[][] arr = new int[n+1][m+1];
		for(int i=1; i<n+1; i++) {
			String[] tmp = scanner.nextLine().split("");
			for(int j=1; j<m+1; j++) {
				arr[i][j] = Integer.parseInt(tmp[j-1]);
			}
		}
		
		scanner.close();
		
		int[][] tmp = new int[n+1][m+1];

		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				if(arr[i][j] == 1) {
					tmp[i][j] = Math.min(Math.min(tmp[i][j-1], tmp[i-1][j]), tmp[i-1][j-1])+1;
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				if(tmp[i][j]>max) max=tmp[i][j];
		
		System.out.println((int)Math.pow(max, 2));
	}
}
