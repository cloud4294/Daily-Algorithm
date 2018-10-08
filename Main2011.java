import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	Baekjoon Online Judge 2011번 - 암호코드 
 * 
 * 	https://www.acmicpc.net/problem/2011
 * 
 */


public class Main2011 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int length = num.length();

		int[] data = new int[length + 1];
		for (int i = 0; i < length; i++) {
			data[i+1] = Integer.parseInt(num.substring(i, i + 1));
		}
		int[] dp = new int[length + 1];
		int mod = 1000000;
		dp[0] = 1;

		for (int i = 1; i <= length; i++) {

			if (data[i] >= 1 && data[i] <= 9) //현재 값이 1 ~ 9 사이라면 이전 자리의 경우의 수와 합산
				dp[i] = (dp[i] + dp[i - 1]) % mod; 

			if(i== 1) 
				continue; // 현재 값이 첫번째 자리라면 이전 자리를 고려할 수 없으므로 넘어감
			if (data[i - 1] == 0) // 이전 값이 0이라면 10이상의 알파벳을 고려할수 없으므로 넘어감
				continue;
			if (data[i - 1] * 10 + data[i] <= 26) //이전 값과 현재값을 더하여 26이하의 수가 된다면 전전자리의 경우의 수와 합산
				dp[i] = (dp[i] + dp[i - 2]) % mod;

		}

		System.out.println(dp[length] % mod);

	}

}
