import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 		Baekjoon Online Judge 2089�� - -2����
 * 
 * 		https://www.acmicpc.net/problem/2089
 * 
 */

public class Main2089 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		if (n == 0) {
			System.out.println(0);
			return;
		}

		while (true) {
			if (n > 0) {
				sb.append(n % (-2)); // n�� ����� ��� n�� -2�� ���������� �������� 0,1 �̹Ƿ� ���� ��¿� �����ش�.
				n /= (-2);
			} else if (n < 0) {
				if (n % (-2) == -1) { // n�� ������ ��� �������� -1�� ���ü� �����Ƿ� �� 1������ �������� 1�� �����.
					n /= (-2);
					sb.append(1);
					n++;
				} else {
					sb.append(n % (-2)); // �������� 0�ΰ���̹Ƿ� �����ش�.
					n /= (-2);
				}
			} else {
				break;
			}

		}
		int length = sb.length();

		for (int i = length - 1; i >= 0; i--) {
			System.out.print(sb.charAt(i));
		}

	}

}
