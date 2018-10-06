import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/*
 * Baekjoon Online Judge 1967�� - Ʈ���� ����
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
				}// �ڽ� ��带 Ž���ϰ� �ش� �������� ���̸� visited������ ����
				
			}
			if(current.parent != null) {
				if(current.parent.visited == 0 && !current.parent.equals(start)) {
					current.parent.visited += current.visited + current.parentlength;
					queue.offer(current.parent);			
				} // �θ��带 �湮���� ������� �θ��带 Ž��
			}
			if (current.adj.size() == 0) {
				if (current.visited >= max) {
					max = current.visited;
					maxnode = current;
				} // �ڽ� ��尡 ���̻������� ���� ��忡�� �������������� �Ÿ��� �ִ밪���� �����Ѵ�
			

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

		}// Ʈ�� ����

		bfs(nodes[1]); // 1�� ��忡�� bfs�� �����Ͽ� ���� �� ��带 ã��
		
		tree start = maxnode;
		
		for (int i = 0; i < N+1; i++) {
			nodes[i].visited = 0;
		} // bfs�� �����Ͽ� �湮�ߴ���带 �ʱ�ȭ
		
		bfs(start); // ã�� ��带 �������� bfs�� �����Ͽ� ���� �� ��带 ã�� �Ÿ��� ���� 
		
		System.out.println(max);
	}

}
