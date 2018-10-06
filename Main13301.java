import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Baekjoon Online Judge 13301번 - 타일 장식물
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
		} //dp로 N번째와 N+1번째 타일 길이를 구함
		
		System.out.println(2 *dp[N] + 2 *dp[N+1]); // N번째와 N+1번째의 변을 합산하여 둘레를 구함
		
		
	}

}
