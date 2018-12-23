import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 		Baekjoon Online Judge 1932번 - 정수 삼각형 
 * 
 * 		https://www.acmicpc.net/problem/1932
 */

public class Main1932 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N][];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			dp[i] = new int[input.length];
			
			for (int j = 0; j < input.length; j++) {
				dp[i][j] = Integer.parseInt(input[j]);
			}
			
		}// 배열 초기화 
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				
				if(j == 0)
					dp[i][j] += dp[i-1][j];
				else if(j == dp[i].length -1)
					dp[i][j] += dp[i-1][j-1];
				else
					dp[i][j] = dp[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]); 
			}
			
		} // 위층의 최대합을 비교하여 현재 값에 더함 
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			if(dp[N-1][i] > max)
				max = dp[N-1][i];
		}
		System.out.println(max); // 마지막층의 최대값을 출력

	}

}
