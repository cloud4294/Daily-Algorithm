import java.util.Scanner;

/*
 *   Baekjoon Online Judge 1904�� - 01Ÿ��
 * 
 *   https://www.acmicpc.net/problem/1904
 */

public class Main1904 {

	static int d = 15746;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];

		dp[1] = 1;
		if (N >= 2)
			dp[2] = 2;

		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % d;
		} // ��Ģ�� ã�� ������ȹ�� ����
		
		System.out.println(dp[N] % d);

	}

}
