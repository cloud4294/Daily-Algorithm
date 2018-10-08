import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  Baekjoon Online Judge 2225번 - 합분해 
 * 
 *  https://www.acmicpc.net/problem/2225
 * 
 */

public class Main2225 {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[][] dp = new long[K + 1][N + 1];
		int mod = 1000000000;
		
		dp[0][0] = 1;
		for (int i = 1; i <= K; i++) {
			for (int j = 0; j <= N; j++) {
				for (int j2 = 0; j2 <= j; j2++) {
					dp[i][j] += dp[i-1][j - j2];
					dp[i][j] %= mod;
				}
			}

		}
		
		System.out.println(dp[K][N] % mod);

	}

}
