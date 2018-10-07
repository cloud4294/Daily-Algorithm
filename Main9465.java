import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Baekjoon Online Judge 9465�� - ��ƼĿ
 * 
 * https://www.acmicpc.net/problem/9465
 * 
 */


public class Main9465 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] output = new int[T];
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] data = new int[n+1][2]; 
			for (int j = 0; j < 2; j++) {
				String[] input = br.readLine().split(" ");
				for (int k = 1; k <= n; k++) {
					data[k][j] = Integer.parseInt(input[k-1]);
				}
			}
			
			int[][] dp = new int[n+1][3];
			
			dp[1][0] = 0;
			dp[1][1] = data[1][0];
			dp[1][2] = data[1][1];
			
			for (int j = 2; j <= n; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					dp[j][0] = Integer.max(dp[j][0], dp[j-1][j2]); //j��° ��ƼĿ�� ���� �ʴ� ���
				}
				dp[j][1] = Integer.max(dp[j-1][2], dp[j-1][0]) + data[j][0]; // j��° ��ƼĿ�� ù��° ���� ��ƼĿ�� ���� ���
				dp[j][2] = Integer.max(dp[j-1][1], dp[j-1][0]) + data[j][1]; // j��° ��ƼĿ�� �ι�° ���� ��ƼĿ�� ���� ���
			}
			
			int max = 0;
			for (int j = 0; j < 3; j++) {
				max = Integer.max(max, dp[n][j]); //n��° ��ƼĿ�� ���� ����� �� �߿��� ���� ũ�Ⱑ ū ���� �ִ밪
			}
			
			output[i] = max;
			
		}
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

}
