import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	Baekjoon Online Judge 2133번 - 타일 채우기 
 * 
 * 	https://www.acmicpc.net/problem/2133
 * 
 */

public class Main2133 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N + 1];
		dp[0] = 1;
		for (int i = 2; i <= N; i += 2) {
			dp[i] = dp[i - 2] * 3;
			for (int j = i - 4; j >= 0; j -= 2) {
				dp[i] += 2 * dp[j];
			}
		}

		System.out.println(dp[N]);

	}

}
