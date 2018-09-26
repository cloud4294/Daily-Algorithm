import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 2167�� - 2���� �迭�� ��
 * 
 * ���� 
 * 2���� �迭�� �־����� �� (i, j) ��ġ���� (x, y) ��ġ������ ����Ǿ� �ִ� ������ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. �迭�� (i, j) ��ġ�� i�� j���� ��Ÿ����.
 * 
 * �Է� 
 * ù° �ٿ� �迭�� ũ�� N, M(1 �� N, M �� 300)�� �־�����. ���� N���� �ٿ��� M���� ������ �迭�� �־�����. �迭�� ���ԵǾ� �ִ� ���� ������ 10,000���� �۰ų� ���� �����̴�. �� ���� �ٿ��� ���� ���� �κ��� ���� K(1 �� K �� 10,000)�� �־�����. ���� K���� �ٿ��� �� ���� ������ i, j, x, y�� �־�����(i �� x, j �� y).
 * 
 * ��� 
 * K���� �ٿ� ������� �迭�� ���� ����Ѵ�. �迭�� ���� 32bit-int ������ �ʰ����� �ʴ´�.
 * 
 * 
 */

public class Main2167 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] data = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int K = Integer.parseInt(br.readLine());
		int[] output = new int[K];
		
		for (int a = 0; a < K; a++) {

			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int sum = 0;
			for (int k = i; k <= x; k++) {
				for (int k2 = j; k2 <= y; k2++) {
					sum += data[k][k2];
				}
			}
			output[a] = sum;
		}
		
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

}
