import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *  Baekjoon Online Judge 3190번 - 뱀
 * 
 *  https://www.acmicpc.net/problem/3190
 *  
 */


public class Main3190 {

	static int[] dir_x = { 1, 0, -1, 0 };
	static int[] dir_y = { 0, -1, 0, 1 };


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;

		int[][] map = new int[102][102];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int l = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[l][c] = 1;
		}

		int L = Integer.parseInt(br.readLine());
		int[] timer = new int[L];
		char[] c_dir = new char[L];
		
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			timer[i] = time;
			c_dir[i] = dir;
		
		}
		
		Queue<Integer>lengthY = new LinkedList<Integer>();
		Queue<Integer>lengthX = new LinkedList<Integer>();
		map[1][1] = 2; 
		
		lengthY.offer(1);
		lengthX.offer(1); // 큐에 뱀에 위치를 넣어줌
		
		int y = 1;
		int x = 2; 
		int time = 1;
		int dir = 0;
		int check = 0;
		
		while (true) {

			if (y == 0 || x == 0 || y == N + 1 || x == N + 1) {
				System.out.println(time);
				return;
			} //벽에 부딪혔을때 종료됨

			if (check < L) {
				if (timer[check] == time) {
					char d = c_dir[check];
					if (d == 'L') {
						dir++;
						if (dir == 4)
							dir = 0;
					} else if (d == 'D') {
						dir--;
						if (dir == -1)
							dir = 3;
					}
					check++;
				}
			} // 방향 전환 명령이 남아있을경우 해당 시간이 되면 방향을 전환함

			lengthX.offer(x);
			lengthY.offer(y); // 현재 위치를 큐에 넣음
			if (map[y][x] == 0) {
				int tx = lengthX.poll();
				int ty = lengthY.poll();
				map[ty][tx] = 0;
				// 사과가 없으면 큐에서 마지막원소를 제거하고 마지막 원소의 위치를 0으로 바꿈 
			}
			map[y][x] = 2; // 뱀의 현재위치를 저장
			y += dir_y[dir];
			x += dir_x[dir];
			time++;

			if (map[y][x] == 2) { // 뱀이 이동할 다음위치에 뱀의 몸이 있으면 종료
				System.out.println(time);
				return;
			}
		}

	}

}
