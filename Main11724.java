import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * Baekjoon Online Judge 11724번 - 연결 요소의 개수
 * 
 * 문제 
 * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 * 
 * 입력 
 * 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
 * 
 * 출력 
 * 첫째 줄에 연결 요소의 개수를 출력한다.
 * 
 * 
 */

public class Main11724 {
	
	static ArrayList<Integer>[] data;
	static int checked[] ;
	
	
	static int bfs(int i) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(i);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			checked[current] = 1;
			for (int j = 0; j < data[current].size(); j++) {
				if(checked[data[current].get(j)] == 0)
					queue.add(data[current].get(j));
			}
			
		}
		return 1;
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		data = new ArrayList[N+1];
		checked = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			data[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int src = Integer.parseInt(st.nextToken());
			int dst = Integer.parseInt(st.nextToken());
			data[src].add(dst);
			data[dst].add(src);
		}
		int count = 0;
		for (int i = 1; i <= N; i++) {
			
			if(checked[i] == 0) {
				count += bfs(i);
			}
		}
		
		System.out.println(count);
	}

}
