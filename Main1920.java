import java.util.Arrays;
import java.util.Scanner;

/*
 *    Baekjoon Online Judge 1920�� - �� ã��
 * 
 *    https://www.acmicpc.net/problem/1920
 */


public class Main1920 {

	static int[] arr;
	static int N;

	static void solve(int key) {
		int start = 0;
		int end = N - 1;
		int mid;

		while (end >= start) {
			mid = (end + start) / 2;

			if (key < arr[mid]) {
				end = mid - 1;
			} else if (key > arr[mid]) {
				start = mid + 1;
			} else if (arr[mid] == key) {
				System.out.println("1");
				return;
			}

		}
		System.out.println("0");

		return;

	} // ����Ž���� �����Ͽ� ã�� ������ ������ 1 ��� ������ 0 ���

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr); // �������� ����

		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int now = sc.nextInt();

			solve(now); // ���� Ž�� ����

		}

	}

}
