import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *   Baekjoon Online Judge 9466번 - 텀 프로젝트
 * 
 *   https://www.acmicpc.net/problem/9466
 * 
 */


public class Main9466 {

	static int[] data;
	static int[] check;
	static int[] step;
	static int n;
	static int start;

	static int dfs(int now) {

		int count = 1;
		int next = now;
		while(true) {
			if(check[next] != 0) { // 현재 정점이 방문한적이 있는 정점이면
				if(now != step[next]) // 현재 dfs에서 방문한 정점이 아니면 0을 반환
					return 0;
				else 
					return count - check[next];	
				// 현재 dfs에서 방문한 정점이면 처음 정점에서 현재 정점까지 거리를 현재 dfs의 길이에서 뺀다. 	
			}
			check[next] = count;
			step[next] = now;
			next = data[next];
			count++; // count를 증가시켜가면서 다음 정점을 찾음
		}
		

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] output = new int[T];
		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			data = new int[n + 1];
			check = new int[n + 1];
			step = new int[n + 1];
			int count = 0;
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				data[j + 1] = Integer.parseInt(input[j]);
			}

			for (int j = 1; j <= n; j++) {
				if (check[j] == 0) {
					count += dfs(j);
				}
			}
			output[i] = n - count; // 사이클이 생성된 정점의 갯수를 전체갯수에서 뺀다.

		}

		for (int i = 0; i < T; i++) {
			System.out.println(output[i]);
		}
	}

}
