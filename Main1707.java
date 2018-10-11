import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 *   Baekjoon Online Judge 1707�� - �̺� �׷���
 * 
 *   https://www.acmicpc.net/problem/1707
 *  
 */

public class Main1707 {

	static ArrayList<Integer>[] list;
	static int[] checked;

	static void dfs(int now, int c) {
		
		if (checked[now] == 0) { // ���� ������ �湮���� �ʾҴٸ�
			checked[now] = c; // ���� ������ c�� üũ
			for (int i = 0; i < list[now].size(); i++) {
				dfs(list[now].get(i), 3 - c); // ���� ������ ����Ǵ� ��� ������ 3-c�� üũ, 1�׷�� 2�׷����� ������.
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
			} // ��� ������ ���� �湮���� �ʾҴٸ� dfs ����

			String answer = "YES";
			for (int j = 1; j < checked.length; j++) {
				for (int j2 = 0; j2 < list[j].size(); j2++) {
					if(checked[j] == checked[list[j].get(j2)]) {
						answer = "NO";
						break;
					}
				}
			} // �� �������� ������ ����� ���� �׷� ��ȣ�� �ٸ��ٸ� YES, �ϳ��� ���ٸ� NO
			output[i] = answer;
		}

		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

}
