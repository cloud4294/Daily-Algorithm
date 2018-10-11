import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *   Baekjoon Online Judge 2331�� - �ݺ�����
 * 
 * 	 https://www.acmicpc.net/problem/2331
 * 
 */

public class Main2331 {

	static int P;
	static int[] data;
	static int count = 0;

	static void dfs(int A) {

		if (data[A] != 0) {
			System.out.println(data[A]-1); // ���������� �̹� �湮������ �ִ������̸� �ش� ���� ���
			return;
		} else {

			data[A] = ++count; // ���� ������ count���� �����ϸ鼭 ����

			int now = 0;
			while (A > 0) {
				int current = A % 10;
				int div = 1;
				for (int i = 0; i < P; i++) {
					div *= current;
				}
				now += div;
				A /= 10;
			} // �� �ڸ����� P�� ���Ͽ� ���� ������ ã�Ƴ�

			dfs(now); // ���������� ���� dfs�� ��������� ����
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		P = Integer.parseInt(input[1]);
		data = new int[1000000];

		dfs(A);
	}

}
