import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *   Baekjoon Online Judge 14501번 - 퇴사
 * 
 *   https://www.acmicpc.net/problem/14501
 * 
 */


public class Main14501 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N + 1];
		int[] P = new int[N + 1];
		int[] dp = new int[N + 1];
		int pay = 0;
		for (int i = 1; i <= N; i++) {
			String[] data = br.readLine().split(" ");
			T[i] = Integer.parseInt(data[0]);
			P[i] = Integer.parseInt(data[1]);
		}

		for (int i = 1; i <= N; i++) {

			if (i + T[i] <= N +1) {
				dp[i] = P[i]; 
				int max = 0;
				for (int j = 1; j <= i; j++) {
					if (j + T[j] <= i && dp[j] > max)
						max = dp[j];
				}
				dp[i] += max;  //i번째 날까지 이어지지 않은 일을 수행한 것중에 가장 큰 돈을 벌은 것을 더한다  
				
				if (dp[i] > pay)
					pay = dp[i];
				
			}


		}

		System.out.println(pay);

	}

}
