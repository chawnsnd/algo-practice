package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class no11052 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		int[] p = new int[N+1]; p[0]=0;
		int[] dp = new int[N+1]; dp[0]=0;
		String[] strArr = scanner.nextLine().split(" ");
		scanner.close();
		for(int i=0; i<N; i++) {
			p[i+1] = Integer.parseInt(strArr[i]);
		}
		
		scanner.close();
		
		dp[1] = p[1];
		for(int i=2; i<N+1; i++) {
			int max = 0;
			for(int j=1; j<i; j++) {
				System.out.println(i+": dp["+(i-j)+"]+p["+j+"]");
				if((dp[i-j]+p[j])>max) max = dp[i-j]+p[j];
			}
			dp[i] = Math.max(max, p[i]);
		}
		System.out.println(dp[N]);
		
	}
}
