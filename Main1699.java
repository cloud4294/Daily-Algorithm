import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 *	Baekjoon Online Judge 1699번 - 제곱수의 합 
 * 
 * 	https://www.acmicpc.net/problem/1699
 * 
 */

public class Main1699 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			dp[i] = i;
			for (int j = 1; j * j <= i; j++) {
				if (dp[i] > dp[i - j * j] + 1) 
					dp[i] = dp[i - j * j] + 1;
				// 마지막 숫자를 j*j로 선택했을 경우 나머지는 i - j *j를 만드는 항의 갯수 + 1
			}
		}
		
		System.out.println(dp[N]);

	}

}
