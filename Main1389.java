import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 		Baekjoon Online Judge 1389�� - �ɺ� �������� 6�ܰ� ��Ģ 
 * 
 * 		https://www.acmicpc.net/problem/1389
 */

public class Main1389 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> list[] = new ArrayList[N + 1]; // ArrayList �迭 ����

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		} 

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int src = Integer.parseInt(st.nextToken());
			int dst = Integer.parseInt(st.nextToken());

			list[src].add(dst);
			list[dst].add(src);
		} // ����Ʈ �ʱ�ȭ 

		Queue<Integer> queue = new LinkedList<Integer>();
		
		int min = Integer.MAX_VALUE; // �ּ� ���ᰪ�� ���� ����
		int minIndex = 0;			 // ����� ����� �ε��� 

		for (int i = 1; i <= N; i++) { // ��� ������ ���� BFS ���� 
			boolean[] checked = new boolean[N + 1]; // �湮 üũ
			int[] count = new int[N + 1]; // ���� i���� �ٸ� ��� ������ ���� depth üũ 
			queue.clear();

			queue.offer(i);
			checked[i] = true;
			count[i] = 0;

			while (!queue.isEmpty()) {
				int now = queue.poll();

				for (int j = 0; j < list[now].size(); j++) {
					int next = list[now].get(j);
					if (checked[next] == false) {

						count[next] = count[now] + 1;

						checked[next] = true;
						queue.offer(next);
					}
				}

			} 
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += count[j];
			} // depth �ջ� 

			if(sum < min) {
				min = sum;
				minIndex = i;
						
			} // ���ᰪ�� ���� min���� ������ ���� 
		}
		
		System.out.println(minIndex);

	}

}
