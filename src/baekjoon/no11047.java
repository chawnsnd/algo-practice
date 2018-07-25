package baekjoon;

import java.util.Scanner;

public class no11047 {
	static int coinCount = 0;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] nk = scanner.nextLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		int[] coins = new int[n];
		for(int i=0; i<n; i++) {
			coins[i] = Integer.parseInt(scanner.nextLine());
		}
		scanner.close();
		
		while(k>0) {
			coinCount++;
			int max = 0;
			for(int i = 0; i < n; i++) {
				if(coins[i]<=k) {
					max = coins[i];
				}
			}
			k -= max;
		}
		
		System.out.println(coinCount);
	}
}
