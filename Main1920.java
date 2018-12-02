import java.util.Arrays;
import java.util.Scanner;

/*
 *    Baekjoon Online Judge 1920번 - 수 찾기
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

	} // 이진탐색을 시행하여 찾는 정수가 있으면 1 출력 없으면 0 출력

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr); // 오름차순 정렬

		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int now = sc.nextInt();

			solve(now); // 이진 탐색 시행

		}

	}

}
