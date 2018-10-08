import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Baekjoon Online Judge 11054번 - 가장 긴 바이토닉 부분 수열
 * 
 * https://www.acmicpc.net/problem/11054
 */

public class Main11054 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		int[] dp = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(input[i]);
		}
		int max = 1;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(dp[j] + 1 > dp[i] && data[i] > data[j]) 
					dp[i] = dp[j] + 1;
			}
			
		}//dp 배열에 가장 긴 증가하는 부분수열을 저장 
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(dp[j] + 1 > dp[i] && data[i] < data[j]) 
					dp[i] = dp[j] + 1;
			}
			
			if(dp[i] > max)
				max = dp[i];
		} // 가장 긴 감소하는 부분수열을 찾음 
		
		System.out.println(max);
		
		
		
	}

}
