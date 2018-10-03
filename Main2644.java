import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 2644번 - 촌수계산
 * 
 * https://www.acmicpc.net/problem/2644
 *  
 */

public class Main2644 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] map = new ArrayList[101];
		int[] visit = new int[101];
		for (int i = 0; i < 101; i++) {
			map[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int src = Integer.parseInt(st.nextToken());
			int dst = Integer.parseInt(st.nextToken());
			map[src].add(dst);
			map[dst].add(src);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);

		visit[start] = 0;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			if(current == end) {
				System.out.println(visit[current]);
				return;
			}
		
			for (int i = 0; i < map[current].size(); i++) {
				if(visit[map[current].get(i)] == 0) {
					queue.offer(map[current].get(i));
					visit[map[current].get(i)] = visit[current] + 1;
				}
					
			}
			
		}// 시작 지점에서 bfs를 시행하여 목적지를 찾으면 목적지까지의 depth를 출력한다.
		
		
		System.out.println(-1);
		
		
	}

}
