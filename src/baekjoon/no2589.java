package baekjoon;

import java.util.LinkedList;
import java.util.Queue;

public class no2589 {
	static class Point {
		int x;
		int y;
		public Point(int x , int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		int res = 0;
		char[][] map = {{'W', 'L', 'L', 'W', 'W', 'W', 'L'},
				{'L', 'L', 'L', 'W', 'L', 'L', 'L'},
				{'L', 'W', 'L', 'W', 'L', 'W', 'W'},
				{'L', 'W', 'L', 'W', 'L', 'L', 'L'},
				{'W', 'L', 'L', 'W', 'L', 'W', 'W'}};
		boolean[][] visited = new boolean[map.length][map[0].length];
		for(int x=0; x<visited.length; x++){
			for(int y=0; y<visited[0].length; y++) {
				visited[x][y] = false;
			}
		}
		for(int x=0; x<map.length; x++){
			for(int y=0; y<map[0].length; y++){
				if(map[x][y]=='L'){
					Point start = new Point(x, y);
					Queue<Point> queue = new LinkedList<>();
					int tempDist = 0;
					visited[x][y] = true;
					up(map, start, queue, visited);
					down(map, start, queue, visited);
					left(map, start, queue, visited);
					right(map, start, queue, visited);
					while(!queue.isEmpty()){
						Point next = queue.poll();
						tempDist++;
						up(map, next, queue, visited);
						down(map, next, queue, visited);
						left(map, next, queue, visited);
						right(map, next, queue, visited);
						System.out.println(tempDist);
					}
					res = Math.max(res, tempDist);
				}
			}
		}
		System.out.println(res);
	}
	static void up(char[][] map, Point point, Queue queue, boolean[][] visited){
		if(point.x - 1 >= 0) {
			if (map[point.x - 1][point.y] == 'L' && !visited[point.x - 1][point.y]) {
				queue.offer(new Point(point.x - 1, point.y));
				visited[point.x - 1][point.y] = true;
			}
		}
	}
	static void down(char[][] map, Point point, Queue queue, boolean[][] visited){
		if(point.x + 1 <= map.length - 1) {
			if (map[point.x + 1][point.y] == 'L' && !visited[point.x+1][point.y]) {
				queue.offer(new Point(point.x + 1, point.y));
				visited[point.x+1][point.y] = true;
			}
		}
	}
	static void left(char[][] map, Point point, Queue queue, boolean[][] visited){
		if(point.y - 1 >= 0) {
			if (map[point.x][point.y - 1] == 'L' && !visited[point.x][point.y-1]) {
				queue.offer(new Point(point.x , point.y - 1));
				visited[point.x][point.y-1] = true;
			}
		}
	}
	static void right(char[][] map, Point point, Queue queue, boolean[][] visited){
		if(point.y + 1 <= map[0].length - 1) {
			if (map[point.x][point.y + 1] == 'L' && !visited[point.x][point.y+1]) {
				queue.offer(new Point(point.x, point.y + 1));
				visited[point.x][point.y+1] = true;
			}
		}
	}
}

