import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 *   Baekjoon Online Judge 4963번 - 섬의 개수
 * 
 *   https://www.acmicpc.net/problem/4963
 *  
 */

public class Main4963 {

	static int[] move_x = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] move_y = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int[][] map;
	static int w;
	static int h;

	static int dfs(int i, int j) {
		map[i][j] = 0; 

		for (int j2 = 0; j2 < 8; j2++) {
			if (i + move_y[j2] < 0 || i + move_y[j2] >= h || j + move_x[j2] < 0 || j + move_x[j2] >= w) 
				continue;
			else {
				if (map[i + move_y[j2]][j + move_x[j2]] == 1) {
					dfs(i + move_y[j2], j + move_x[j2]);
				}
			}

		}
		
		return 1;

	} // dfs를 시행하여 방문하지 않은 모든 지점을 방문하고 하나의 섬으로 체크한다.

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer> output = new ArrayList<Integer>();
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) {
				for (int i = 0; i < output.size(); i++) {
					System.out.println(output.get(i));
				}
				
				return;
			}

			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] == 1) // 모든 지점에 대해 섬이라면 dfs를 시행한다
						count += dfs(i,j); // 
				}
			}

			output.add(count);
		}

	}

}
