import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 *   Baekjoon Online Judge 1167번 - 트리의 지름
 * 
 *   https://www.acmicpc.net/problem/1167
 */

public class Main1167 {

	static class point {
		int num;
		ArrayList<point> adj;
		ArrayList<Integer> length;

		point(int num) {
			this.num = num;
			this.adj = new ArrayList<point>();
			this.length = new ArrayList<Integer>();

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		point[] map = new point[V + 1];
		for (int i = 1; i <= V; i++) {
			map[i] = new point(i);
		}

		for (int i = 1; i <= V; i++) {
			String[] input = br.readLine().split(" ");
			int now = Integer.parseInt(input[0]);
			for (int j = 1; j < input.length; j += 2) {
				int dst = Integer.parseInt(input[j]);
				if (dst != -1) {
					int g = Integer.parseInt(input[j + 1]);
					map[now].adj.add(map[dst]);
					map[now].length.add(g);
				}
			}
		} // 트리 구성

		int output = 0;

		int[] check = new int[V + 1];
		int[] count = new int[V + 1];
		Queue<point> queue = new LinkedList<point>();
		queue.offer(map[1]); 
		check[1] = 1;
		int max = 0;
		int start = 0;
		while (!queue.isEmpty()) {
			point now = queue.poll();
			for (int j = 0; j < now.adj.size(); j++) {
				int num = now.adj.get(j).num;
				if (check[num] == 0) {
					check[num] = 1;
					queue.offer(now.adj.get(j));
					count[num] = count[now.num] + now.length.get(j);
					if (count[num] > max) {
						max = count[num];
						start = num;
					}
				}

			}
		} // 1번 노드에서 가장 거리가 먼 노드를 찾아 start에 저장
		check = new int[V + 1];
		count = new int[V + 1];

		queue.offer(map[start]);
		check[start] = 1;
		max = 0;
		while (!queue.isEmpty()) {
			point now = queue.poll();
			for (int j = 0; j < now.adj.size(); j++) {
				int num = now.adj.get(j).num;
				if (check[num] == 0) {
					check[num] = 1;
					queue.offer(now.adj.get(j));
					count[num] = count[now.num] + now.length.get(j);
					if (count[num] > max) {
						max = count[num];
					}
				}

			}

			if (max > output)
				output = max;
		} // start에서 가장 먼노드를 찾아 거리를 출력한다.
 
		System.out.println(output);
	}

}
