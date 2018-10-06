import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/*
 * Baekjoon Online Judge 1967번 - 트리의 지름
 * 
 * https://www.acmicpc.net/problem/1967
 * 
 */

public class Main1967 {

	static tree[] nodes;
	static int max = 0;
	static tree maxnode;

	static class tree {
		int data;
		int visited;
		tree parent;
		int parentlength;
		ArrayList<tree> adj;
		ArrayList<Integer> length;

		tree(int data) {
			this.data = data;
			this.parent = null;
			this.visited = 0;
			this.adj = new ArrayList<tree>();
			this.length = new ArrayList<Integer>();
		}

	}

	public static void bfs(tree start) {

		Queue<tree> queue = new LinkedList<tree>();

		queue.add(start);

		while (!queue.isEmpty()) {
			tree current = queue.poll();
			for (int i = 0; i < current.adj.size(); i++) {
				tree adj = current.adj.get(i);
				int length = current.length.get(i);
				if (adj.visited == 0 && !adj.equals(start)) {
					queue.offer(adj);
					adj.visited += current.visited + length;
				}// 자식 노드를 탐색하고 해당 노드까지의 길이를 visited변수에 저장
				
			}
			if(current.parent != null) {
				if(current.parent.visited == 0 && !current.parent.equals(start)) {
					current.parent.visited += current.visited + current.parentlength;
					queue.offer(current.parent);			
				} // 부모노드를 방문하지 않은경우 부모노드를 탐색
			}
			if (current.adj.size() == 0) {
				if (current.visited >= max) {
					max = current.visited;
					maxnode = current;
				} // 자식 노드가 더이상없을경우 시작 노드에서 마지막노드까지의 거리의 최대값으로 갱신한다
			

			}
			

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nodes = new tree[N + 1];
		for (int i = 0; i < N+1; i++) {
			nodes[i] = new tree(i);
		}

		for (int i = 0; i < N - 1; i++) {
			String[] input = br.readLine().split(" ");

			int data = Integer.parseInt(input[0]);
			int in = Integer.parseInt(input[1]);
			int length = Integer.parseInt(input[2]);

			nodes[data].adj.add(nodes[in]);
			nodes[data].length.add(length);
			nodes[in].parent = nodes[data];
			nodes[in].parentlength = length;

		}// 트리 구성

		bfs(nodes[1]); // 1번 노드에서 bfs를 시행하여 가장 먼 노드를 찾음
		
		tree start = maxnode;
		
		for (int i = 0; i < N+1; i++) {
			nodes[i].visited = 0;
		} // bfs를 시행하여 방문했던노드를 초기화
		
		bfs(start); // 찾은 노드를 기준으로 bfs를 시행하여 가장 먼 노드를 찾아 거리를 구함 
		
		System.out.println(max);
	}

}
