import java.util.Arrays;
import java.util.Scanner;

/*
 *   Baekjoon Online Judge 16208�� - ������
 * 
 *   https://www.acmicpc.net/problem/16208
 */

public class Main16208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[n];
		long length = 0;
		long result = 0;
		for (int i = 0; i < n; i++) {
			data[i] = sc.nextInt();
			length += data[i];
		}
		Arrays.sort(data); // ���� �ѵ� ���� �ͺ��� �߶�
		long[] sum = new long[n];

		for (int i = 0; i < n; i++) {
			length -= data[i];
			sum[i] = length;
		} // �߶� �������� �������� ���̸� ���� ����ؼ� �迭�� ����
		for (int i = 0; i < n; i++) {
			long now = sum[i] * data[i];
			result += now;
		} // �߶� ���̿� �������� ���Ͽ� ����� ����

		System.out.println(result);
	}

}
