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
		
		int count = 0; // 가장 적은 비행기의 종류를 출력할 변수 
		while(!queue.isEmpty()) {
			
			int now = queue.poll();
			
			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				if(checked[next] == false) {
					checked[next] = true;
					queue.offer(next);
					count++; // 탐색되지 않은 곳을 방문할때 +1, 종류를 찾는 것이므로 돌아오는 것은 계산하지 않는다. 
				}
			}
			
			
		}
		
		System.out.println(count); // 결과 출력
		
	}// BFS 시행 
	
	
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
			} // ArrayList 배열 생성
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int src = Integer.parseInt(st.nextToken());
				int dst = Integer.parseInt(st.nextToken());
				list[src].add(dst);
				list[dst].add(src);
			} // 리스트 초기화 
			
			BFS(1); // 임의의 정점에서 BFS 시행 
			
		}

	}

}
