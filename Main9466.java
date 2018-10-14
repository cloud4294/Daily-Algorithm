import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *   Baekjoon Online Judge 9466�� - �� ������Ʈ
 * 
 *   https://www.acmicpc.net/problem/9466
 * 
 */


public class Main9466 {

	static int[] data;
	static int[] check;
	static int[] step;
	static int n;
	static int start;

	static int dfs(int now) {

		int count = 1;
		int next = now;
		while(true) {
			if(check[next] != 0) { // ���� ������ �湮������ �ִ� �����̸�
				if(now != step[next]) // ���� dfs���� �湮�� ������ �ƴϸ� 0�� ��ȯ
					return 0;
				else 
					return count - check[next];	
				// ���� dfs���� �湮�� �����̸� ó�� �������� ���� �������� �Ÿ��� ���� dfs�� ���̿��� ����. 	
			}
			check[next] = count;
			step[next] = now;
			next = data[next];
			count++; // count�� �������Ѱ��鼭 ���� ������ ã��
		}
		

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] output = new int[T];
		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			data = new int[n + 1];
			check = new int[n + 1];
			step = new int[n + 1];
			int count = 0;
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				data[j + 1] = Integer.parseInt(input[j]);
			}

			for (int j = 1; j <= n; j++) {
				if (check[j] == 0) {
					count += dfs(j);
				}
			}
			output[i] = n - count; // ����Ŭ�� ������ ������ ������ ��ü�������� ����.

		}

		for (int i = 0; i < T; i++) {
			System.out.println(output[i]);
		}
	}

}
