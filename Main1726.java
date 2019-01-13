import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 		Baekjoon Online Judge 1726번 - 로봇
 * 
 * 		https://www.acmicpc.net/problem/1726
 */


public class Main1726 {

	static int[][] map;
	static boolean[][][] checked;
	static int N, M;
	static int[] my = { -1, 0, 1, 0 };
	static int[] mx = { 0, 1, 0, -1 };
	static point dst;
	static int result = Integer.MAX_VALUE;

	static class point {
		int y;
		int x;
		int d;
		int count;

		public point(int y, int x, int d, int count) {
			this.y = y;
			this.x = x;
			this.d = d;
			this.count = count;
		}
	} // 좌표와 방향 이동횟수를 저장하는 클래스 

	public static void solve(point src) {

		Queue<point> queue = new LinkedList<>();
		queue.offer(src);
		checked[src.y][src.x][src.d] = true;

		while (!queue.isEmpty()) {

			point now = queue.poll();
		
			if (now.y == dst.y && now.x == dst.x && now.d == dst.d) {
				
				if (now.count< result) {
					result = now.count;
				}

			} // 목적지에 도착했을 때 현재 이동횟수보자 작으면 갱신 

			for (int i = 0; i < 4; i++) {
				int dir = (now.d + i) % 4;
				int nc = now.count;
				if ((now.d + 2) % 4 == dir) {
					nc += 2;
				} else if (now.d != dir) {
					nc++;
				}
				if(checked[now.y][now.x][dir] == false) {
					checked[now.y][now.x][dir] = true;
					queue.offer(new point(now.y,now.x,dir,nc));
				}
			} // 현재위치에서 회전하는 경우를 큐에 넣음 
			
			for (int j = 1; j <= 3; j++) {
				int ny = now.y + j * my[now.d];
				int nx = now.x + j * mx[now.d];
				if (ny < 1 || ny > M || nx < 1 || nx > N || map[ny][nx] != 0) {
					break;
				} else if (checked[ny][nx][now.d] == true) {
					continue;
				}
				checked[ny][nx][now.d] = true;
				queue.offer(new point(ny, nx, now.d, now.count + 1));
			} // 현재위치에서 현재 방향으로 이동하느 경우를 큐에 넣음 

		}

	}
	
	public static int rotate(int d) {
		if (d == 2)
			return 3;
		else if (d == 3)
			return 2;
		else if (d == 4)
			return 0;
		else 
			return d;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		map = new int[M + 1][N + 1];
		checked = new boolean[M + 1][N + 1][4];

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		} // 지형정보 초기화 
		
		int y = sc.nextInt();
		int x = sc.nextInt();
		int d = sc.nextInt();
		d = rotate(d);

		point src = new point(y, x, d, 0); // 시작점 
		y = sc.nextInt();
		x = sc.nextInt();
		d = sc.nextInt();
		d = rotate(d);
		
		dst = new point(y, x, d, 0); // 목적지

		solve(src);

		System.out.println(result);
	}

}
