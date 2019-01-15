import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 		Baekjoon Online Judge 11055�� - ���� ū ���� �κ� ����
 * 
 * 		https://www.acmicpc.net/problem/11055
 */


public class Main11055 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] data = new int[N];
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			dp[i] = data[i];
		}// ������ �ʱ�ȭ 
		
		int max = data[0];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] + data[i] > dp[i] && data[j] < data[i])
					dp[i] = dp[j] + data[i];
			}
			if (dp[i] > max)
				max = dp[i];
		} // i��° ���� ���� ū ���� �κ� ������ ���� dp[i]�� ���� 

		System.out.println(max);

	}

}
