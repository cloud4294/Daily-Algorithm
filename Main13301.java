import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Baekjoon Online Judge 13301�� - Ÿ�� ��Ĺ�
 * 
 * https://www.acmicpc.net/problem/13301
 */


public class Main13301 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+2];
		
		dp[1] = 1;
		if(N == 1) {
			System.out.println(4);
			return;
		}else if(N== 2) {
			System.out.println(6);
			return;
		}		
		dp[2] = 1;
		for (int i = 3; i <= N+1; i++) {
			dp[i] = dp[i-1] +dp[i-2];
		} //dp�� N��°�� N+1��° Ÿ�� ���̸� ����
		
		System.out.println(2 *dp[N] + 2 *dp[N+1]); // N��°�� N+1��°�� ���� �ջ��Ͽ� �ѷ��� ����
		
		
	}

}
