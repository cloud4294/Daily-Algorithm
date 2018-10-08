import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 	Baekjoon Online Judge 1912번 - 연속 합
 * 
 * 	https://www.acmicpc.net/problem/1912
 * 
 */

public class Main1912 {

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

		dp[0] = data[0];
		int max = dp[0];
		for (int i = 1; i < N; i++) {
			dp[i] = data[i]; 
			if (dp[i - 1] + data[i] > dp[i]) // 현재 값에서 가질수 있는 최대 연속합을 찾아 갱신
				dp[i] = dp[i - 1] + data[i];
			
			if(dp[i] > max)
				max = dp[i];
		}
		
		System.out.println(max);

		
		
	}

}
