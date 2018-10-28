import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 *   Baekjoon Online Judge 1753번 - 최단경로
 * 
 *   https://www.acmicpc.net/problem/1753
 */

public class Main1753 {

	static int V;
	static int E;
	static int K;
	static ArrayList<edge>[] g;
	static int[] visited;
	static int[] d;
	static int INF = 1000000000;

	static class edge {
		int vertex;
		int weight;

		edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

	}

	static void dijkstra(int start) {

		d[start] = 0;
		Queue<edge> queue = new LinkedList<edge>();

		queue.offer(new edge(start, 0));

		while (!queue.isEmpty()) {
			int current = queue.peek().vertex;
			int distance = queue.peek().weight;
			queue.poll();
			if (d[current] < distance)
				continue;
			for (int i = 0; i < g[current].size(); i++) {
				int next = g[current].get(i).vertex;
				int nextDistance = distance + g[current].get(i).weight;
				if (nextDistance < d[next]) {
					d[next] = nextDistance;
					queue.offer(new edge(next, nextDistance));
				}
			}// 다음위치의 거리가 저장된 거리 값보다 작을 때 거리를 갱신하고 큐에 넣음 

		}

	} //다익스트라 알고리즘 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();
		g = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			g[i] = new ArrayList<edge>();
		}
		visited = new int[V + 1];
		d = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			d[i] = INF;
		}

		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			g[u].add(new edge(v, w));

		}

		dijkstra(K);
		for (int i = 1; i <= V; i++) {

			if (d[i] == INF)
				System.out.println("INF");
			else
				System.out.println(d[i]);
		} 

	}

}
