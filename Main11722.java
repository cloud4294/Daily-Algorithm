import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 11722�� - ���� �� �����ϴ� �κ� ����
 * 
 * https://www.acmicpc.net/problem/11722
 * 
 */

public class Main11722 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] data = new int[N + 1];
		int[] dp = new int[N + 1];

		int max = 1;

		for (int i = N; i > 0; i--) {
			data[i] = Integer.parseInt(st.nextToken()); // �Է��� ������ �����ϴ� �κ� ������ ã�� ������ ����
		}

		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (dp[j] + 1 > dp[i] && data[j] < data[i]) // ���� ������ ���� ���� ���߿��� ���̰� ���� ����� ����
					dp[i] = dp[j] + 1;

				if (dp[i] > max)
					max = dp[i];
			}
		}

		System.out.println(max);
	}

}
