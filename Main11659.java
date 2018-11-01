import java.util.Scanner;

/*
 *   Baekjoon Online Judge 11659�� - ���� �� ���ϱ� 4
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
		}// 0 ���� i��°���� ���� �迭�� ����

		for (int i = 0; i < M; i++) {
			int I = sc.nextInt();
			int J = sc.nextInt();
			System.out.println(dp[J] - dp[I - 1]); 
		}
		// 0 ���� j ������ �տ��� 0 ���� i - 1������ ���� ����.
	}

}
