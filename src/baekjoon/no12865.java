package baekjoon;

import java.util.Scanner;

public class no12865 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] nw = scanner.nextLine().split(" ");
		int n = Integer.parseInt(nw[0]);
		int w = Integer.parseInt(nw[1]);
		int[][] item = new int[n][2];
		for(int i=0; i<n; i++) {
			String[] tmp = scanner.nextLine().split(" ");
			item[i][0] = Integer.parseInt(tmp[0]);
			item[i][1] = Integer.parseInt(tmp[1]);
		}
		scanner.close();
		
		int maxValue = 0;
		for(int i=0; i<n; i++) {
			
		}
		for(int i=0; i<n; i++) {
			if(item[i][0]<w) {
				
			}
		}
	}
}
