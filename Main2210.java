import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 		Baekjoon Online Judge 9461번 - 파도반 수열
 * 
 * 		https://www.acmicpc.net/problem/2210
 */

public class Main2210 {

	static String[][] map;
	static int[] my = { -1, 0, 1, 0 };
	static int[] mx = { 0, 1, 0, -1 };
	static List<String> list;

	public static void solve(int i, int j, int k, String line) {

		if (k == 6) { // 완성된 숫자가 길이가 6이고 list에 없으면 list에 추가 
			if(!list.contains(line))
				list.add(line);
		} else {
			line += map[i][j];
			for (int l = 0; l < 4; l++) {
				int ny = i + my[l];
				int nx = j + mx[l];

				if (map[ny][nx] != null) {
					solve(ny, nx, k + 1, line);
				}
			}// 4방향에 대해 
		}

	} 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new String[7][7];
		list = new ArrayList<>();

		for (int i = 1; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 6; j++) {
				map[i][j] = st.nextToken();
			}
		}// 입력값 초기화 
		
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				solve(i, j, 0, "");
			}
		} // 모든 지점에 대해 탐색 수행

		System.out.println(list.size());
	}

}
