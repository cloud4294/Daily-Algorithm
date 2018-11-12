import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 *   Baekjoon Online Judge 4485번 - 녹색 옷 입은 애가 젤다지?
 * 
 *   https://www.acmicpc.net/problem/4485
 */

public class Main4485 {

	static int[][] map;
	static int[][] value;
	static int N;

	static int[] mx = { -1, 1, 0, 0 };
	static int[] my = { 0, 0, -1 ,1};

	static class point {
		int cost;
		int y;
		int x;

		point(int cost,int y, int x) {
			this.cost = cost;
			this.y = y;
			this.x = x;
		}

	}

	static int solve() {
		
		Queue<point> queue = new LinkedList<point>();
		
		queue.offer(new point(map[0][0],0,0));
		value[0][0] = map[0][0];
		
		while(!queue.isEmpty()) {
			point now = queue.poll();
			
			if(value[now.y][now.x] < now.cost) {
				continue;
			}
			for (int i = 0; i < 4; i++) {
				
				if(now.y+my[i] >= 0 && now.y+my[i] < N && now.x+mx[i] >= 0 && now.x+mx[i] < N) {
					if(value[now.y][now.x] + map[now.y+my[i]][now.x+mx[i]] < value[now.y+my[i]][now.x+mx[i]]){
						value[now.y+my[i]][now.x+mx[i]] =  value[now.y][now.x] + map[now.y+my[i]][now.x+mx[i]];
						queue.offer(new point(value[now.y+my[i]][now.x+mx[i]],now.y+my[i],now.x+mx[i]));
					}
					
					
				}
			}
			
			
		} //다음지점까지의 합이  현재지점까지의 합과 다음지점의 값의 합보다 작으면 교체하고 큐에 넣는다. 
		
		return value[N-1][N-1];
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == 0)
				break;

			map = new int[N][N];
			value = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(input[j]);
					value[i][j] = Integer.MAX_VALUE;
				}
			}
			
			count++;
			System.out.println("Problem " + count +": " + solve());

		}
		

	}

}
