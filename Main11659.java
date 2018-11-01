import java.util.Scanner;

/*
 *   Baekjoon Online Judge 11659번 - 구간 합 구하기 4
 * 
 *   https://www.acmicpc.net/problem/11659
 * 
 */

public class Main11659 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] dp = new int[N + 1];
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += sc.nextInt();
			dp[i] = sum;
		}// 0 부터 i번째까지 합을 배열에 저장

		for (int i = 0; i < M; i++) {
			int I = sc.nextInt();
			int J = sc.nextInt();
			System.out.println(dp[J] - dp[I - 1]); 
		}
		// 0 부터 j 까지의 합에서 0 부터 i - 1까지의 합을 뺀다.
	}

}
