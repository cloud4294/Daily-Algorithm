import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 11053�� - ���� �� �����ϴ� �κ� ����
 * 
 * https://www.acmicpc.net/problem/11053
 *  
 */

public class Main11053 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 1;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(data[j] < data[i] && dp[i] < dp[j] +1) { // ���� ������ ���� ���� ���߿��� ���̰� ���� ����� ����
					dp[i] = dp[j] + 1;
					if(dp[i] > max)
						max = dp[i];
				}
					
			}
		}
		
		System.out.println(max);
		
	}

}
