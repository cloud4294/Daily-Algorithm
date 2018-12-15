import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
 * 		Baekjoon Online Judge 11724번 - 연결요소의 개수
 * 
 * 		https://www.acmicpc.net/problem/11724
 * 
 */


public class Main11724 {
	static boolean[] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[] check = new boolean[N+1];
		
		List<Integer>[] list = new List[N+1];
		
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		
		for (int i = 0; i < M; i++) {
			int src = sc.nextInt();
			int dst = sc.nextInt();
			
			list[src].add(dst);
			list[dst].add(src);
		} // 그래프 구성
		
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if(check[i] == false) {
				count++;
				Queue<Integer> queue = new LinkedList<Integer>();
				queue.offer(i);
				check[i] = true;
				
				while(!queue.isEmpty()){
					int now = queue.poll();
					
					for (int j = 0; j < list[now].size(); j++) {
						int next = list[now].get(j);
						if(check[next] == false) {
							check[next] = true;
							queue.offer(next);
						}
					}
				}
				
				
			}
		} // 방문하지 않은 모든 노드에 대해서 bfs를 시행, bfs시행 횟수를 출력
		System.out.println(count);
	}
}
