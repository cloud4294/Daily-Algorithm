import java.util.Scanner;

/*
 *   Baekjoon Online Judge 16456번 - 하와와 대학생쨩 하와이로 가는거시와요~
 * 
 *   https://www.acmicpc.net/problem/16456
 */

public class Main16456 {

	static int[] dp = new int[50001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 3;
		for (int i = 5; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 3]) % 1000000009;
		} // 규칙을 찾아 dp로 해결

		System.out.println(dp[n]);

	}

}
