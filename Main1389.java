import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 		Baekjoon Online Judge 1389번 - 케빈 베이컨의 6단계 법칙 
 * 
 * 		https://www.acmicpc.net/problem/1389
 */

public class Main1389 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> list[] = new ArrayList[N + 1]; // ArrayList 배열 생성

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		} 

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int src = Integer.parseInt(st.nextToken());
			int dst = Integer.parseInt(st.nextToken());

			list[src].add(dst);
			list[dst].add(src);
		} // 리스트 초기화 

		Queue<Integer> queue = new LinkedList<Integer>();
		
		int min = Integer.MAX_VALUE; // 최소 연결값을 넣을 변수
		int minIndex = 0;			 // 결과를 출력할 인덱스 

		for (int i = 1; i <= N; i++) { // 모든 정점에 대해 BFS 시행 
			boolean[] checked = new boolean[N + 1]; // 방문 체크
			int[] count = new int[N + 1]; // 정점 i에서 다른 모든 정점에 대한 depth 체크 
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
			} // depth 합산 

			if(sum < min) {
				min = sum;
				minIndex = i;
						
			} // 연결값의 합이 min보다 낮으면 갱신 
		}
		
		System.out.println(minIndex);

	}

}
