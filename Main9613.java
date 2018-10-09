import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	Baekjoon Online Judge 9613�� - GCD�� 
 * 
 * 	https://www.acmicpc.net/problem/9613
 * 
 */

public class Main9613 {

	static int gcd(int a, int b) {

		if (b == 0) {
			return a;
		}
		else {
			return gcd(b, a % b);
		}
	} // ��Ŭ���� ȣ����

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] output = new long[T];
		for (int i = 0; i < T; i++) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int[] data = new int[n];
			for (int j = 0; j < n; j++) {
				data[j] = Integer.parseInt(input[j + 1]);
			}
			long sum = 0;
			for (int j = 0; j < n; j++) {
				for (int j2 = j + 1; j2 < n; j2++) {
					sum += gcd(data[j],data[j2]); //������ ���� gcd�� ���Ͽ� �ջ�
				}
			}

			output[i] = sum;
		}
		for (int i = 0; i < T; i++) {
			System.out.println(output[i]);
		}
	}

}
