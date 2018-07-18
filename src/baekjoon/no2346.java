package baekjoon;

import java.util.Scanner;

public class no2346 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		String[] strArr = scanner.nextLine().split(" ");
		scanner.close();
		int[] balloons = new int[N];
		for(int i=0; i<N; i++) {
			balloons[i] = Integer.parseInt(strArr[i]);
		}
		scanner.close();
		
		int balloon = 0;
		while(balloons.length>0) {
			runBalloon(balloons, balloon);
		}
	}
	static void runBalloon(int[] balloons, int balloon) {
		int[] newBalloons = new int[balloons.length-1];
		System.out.println(balloon);
		//정상적인 경우
		if(balloon+balloons[balloon]>=0 && balloon+balloons[balloon]<=balloons.length-1) {
			int i = 0;
			while(i<=balloons.length) {
				if(i==balloon) {
					i++;
					continue;
				}
				newBalloons[i] = balloons[i];
				i++;
				System.out.println(i);
			}
		}else if(balloon+balloons[balloon]<0) {
			int runBalloon = balloons.length - balloons[balloon];
			int i = 0;
			while(i<=balloons.length) {
				if(i==runBalloon) {
					i++;
					continue;
				}
				newBalloons[i] = balloons[i];
				i++;
			}
		}else{
			int runBalloon = balloon+balloons[balloon]-balloons.length;
			int i = 0;
			while(i<=balloons.length) {
				if(i==runBalloon) {
					i++;
					continue;
				}
				newBalloons[i] = balloons[i];
				i++;
			}
		}
		runBalloon(newBalloons, balloon);
	}
}
