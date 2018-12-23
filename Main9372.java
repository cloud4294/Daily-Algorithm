import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9372 {

	static List<Integer>[] list;
	static boolean[] checked;
	
	public static void BFS(int start) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		checked[start] = true;
		
		int count = 0; // ���� ���� ������� ������ ����� ���� 
		while(!queue.isEmpty()) {
			
			int now = queue.poll();
			
			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				if(checked[next] == false) {
					checked[next] = true;
					queue.offer(next);
					count++; // Ž������ ���� ���� �湮�Ҷ� +1, ������ ã�� ���̹Ƿ� ���ƿ��� ���� ������� �ʴ´�. 
				}
			}
			
			
		}
		
		System.out.println(count); // ��� ���
		
	}// BFS ���� 
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			list = new ArrayList[N+1];
			checked = new boolean[N+1];
			
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<Integer>();
			} // ArrayList �迭 ����
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int src = Integer.parseInt(st.nextToken());
				int dst = Integer.parseInt(st.nextToken());
				list[src].add(dst);
				list[dst].add(src);
			} // ����Ʈ �ʱ�ȭ 
			
			BFS(1); // ������ �������� BFS ���� 
			
		}

	}

}
