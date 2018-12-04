import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 	  Baekjoon Online Judge 2698번 - 인접한 비트의 개수
 * 
 *    https://www.acmicpc.net/problem/2698
 */

public class Main2698 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][][] dp = new int[101][101][2];
		StringTokenizer st;

		dp[1][0][0] = 1;
		dp[1][0][1] = 1;

		for (int j = 2; j <= 100; j++) {
			for (int j2 = 0; j2 < j; j2++) {
				dp[j][j2][0] = dp[j - 1][j2][0] + dp[j - 1][j2][1];
				dp[j][j2][1] = dp[j - 1][j2][0] + ((j2 > 0) ? dp[j - 1][j2 - 1][1] : 0);
			}
		}// 이전 비트에서 0을 추가하는 경우와 1을 추가하는 경우로 나누어 dp 수행
		
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			System.out.println(dp[n][k][0] + dp[n][k][1]);
		}

	}

}
