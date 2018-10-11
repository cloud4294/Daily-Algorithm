import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 *   Baekjoon Online Judge 1707번 - 이분 그래프
 * 
 *   https://www.acmicpc.net/problem/1707
 *  
 */

public class Main1707 {

	static ArrayList<Integer>[] list;
	static int[] checked;

	static void dfs(int now, int c) {
		
		if (checked[now] == 0) { // 현재 지점을 방문하지 않았다면
			checked[now] = c; // 현재 지점을 c로 체크
			for (int i = 0; i < list[now].size(); i++) {
				dfs(list[now].get(i), 3 - c); // 현재 지점과 연결되는 모든 지점을 3-c로 체크, 1그룹과 2그룹으로 나눈다.
			}
		} 
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String[] output = new String[T];
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			list = new ArrayList[V + 1];

			for (int j = 0; j < list.length; j++) {
				list[j] = new ArrayList<Integer>();
			}
			checked = new int[V + 1];
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int src = Integer.parseInt(st.nextToken());
				int dst = Integer.parseInt(st.nextToken());

				list[src].add(dst);
				list[dst].add(src);
			}

			for (int j = 1; j <= V; j++) {
				if (checked[j] == 0) {
					dfs(j,2);
				}
			} // 모든 정점에 대해 방문하지 않았다면 dfs 시행

			String answer = "YES";
			for (int j = 1; j < checked.length; j++) {
				for (int j2 = 0; j2 < list[j].size(); j2++) {
					if(checked[j] == checked[list[j].get(j2)]) {
						answer = "NO";
						break;
					}
				}
			} // 각 정점에서 정점에 연결된 노드와 그룹 번호가 다르다면 YES, 하나라도 같다면 NO
			output[i] = answer;
		}

		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

}
