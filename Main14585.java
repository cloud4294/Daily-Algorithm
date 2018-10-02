import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 14585�� - �������
 * 
 * https://www.acmicpc.net/problem/14585
 * 
 */

public class Main14585 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] dp = new int[301][301];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			dp[y][x] = M - x - y;
		}// �� ��ġ�� ���������� ���� ������ ���� �迭�� �־��ش�

		for (int i = 0; i <= 300; i++) {
			for (int j = 0; j <= 300; j++) {
				if (i == 0 && j >= 1) {
					dp[i][j] = Math.max(dp[i][j], dp[i][j] + dp[i][j - 1]);
				} else if (j == 0 && j >= 1) {
					dp[i][j] = Math.max(dp[i][j], dp[i][j] + dp[i - 1][j]);
				} else if (i >= 1 && j >= 1) {
					dp[i][j] = Math.max(dp[i][j] + dp[i - 1][j], dp[i][j] + dp[i][j - 1]);
				}// ���̳��� ���α׷���, ���ʰ� �������� �迭���� ���簪�� �������� �� ū���� ���� ���� �ִ´�.
			}
		}
		int max = 0;
		for (int i = 0; i <= 300; i++) {
			for (int j = 0; j <= 300; j++) {

				if (dp[i][j] > max)
					max = dp[i][j];
			}

		}

		System.out.println(max);
	}

}
