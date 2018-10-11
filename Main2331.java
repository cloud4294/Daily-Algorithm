import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *   Baekjoon Online Judge 2331번 - 반복수열
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
			System.out.println(data[A]-1); // 현재지점이 이미 방문한적이 있는지점이면 해당 값을 출력
			return;
		} else {

			data[A] = ++count; // 현재 지점의 count값을 증가하면서 진행

			int now = 0;
			while (A > 0) {
				int current = A % 10;
				int div = 1;
				for (int i = 0; i < P; i++) {
					div *= current;
				}
				now += div;
				A /= 10;
			} // 각 자리수를 P번 곱하여 다음 지점을 찾아냄

			dfs(now); // 다음지점에 대해 dfs를 재귀적으로 시행
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
