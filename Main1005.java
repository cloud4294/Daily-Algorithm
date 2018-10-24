import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 	 Baekjoon Online Judge 1005�� - ACM Craft
 * 
 *   https://www.acmicpc.net/problem/1005
 *   
 */

public class Main1005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] cost = new int[N + 1];
			int[] dp = new int[N + 1];
			int[] indegree = new int[N + 1];
			for (int j = 1; j <= N; j++) {
				cost[j] = sc.nextInt();
			}
			int[][] link = new int[N+1][N+1];
		

			for (int j = 0; j < K; j++) {
				int src = sc.nextInt();
				int dst = sc.nextInt();
				link[src][dst] = 1;
				indegree[dst]++;
			}
			int W = sc.nextInt();
			
			Queue<Integer> queue = new LinkedList<Integer>();
			for (int j = 1; j <= N; j++) {
				if(indegree[j] == 0) {
					queue.offer(j);
					dp[j] = cost[j];
				}
			}
			
			while(!queue.isEmpty()) {
				int now = queue.poll(); 
				
				for (int j = 1; j <= N; j++) {
					if(link[now][j] == 1) {
						dp[j] = Integer.max(dp[j], dp[now]+ cost[j]); // ���� �������� ���������� ������������ ������������ ������ �ִ� �ִ밪�� ����
						indegree[j]--;
						if(indegree[j] == 0) { // ���������� ���̻� ���� ���̾����� ť�� �߰� 
							queue.offer(j);
						}
					}
					
				}
				
				
			}
			
			System.out.println(dp[W]);
			
		}
	}

}
