import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 
 * Baekjoon Online Judge 10815번 - 숫자카드
 * 
 * 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 
 * 숫자 M개가 주어졌을 때, 이 숫자가 적혀있는 숫자 카드를 상근이가 가지고 있는지 
 * 아닌지를 구하는 프로그램을 작성하시오.
 * 
 */


public class Main10815 {
	static int[] input;

	static int solve(int current, int start, int end) {
		if ((end - start) % 2 == 0) {	// 갯수가 홀수인경우와 짝수인 경우로 나누어 이진 탐색 시행
			int mid = (start + end) / 2;
			if (start > end) {
				return 0;
			} else if (current == input[mid]) {
				return 1;
			} else if (current < input[mid])
				return solve(current, start, mid - 1);
			else
				return solve(current, mid + 1, end);
		} else {
			int mid = (start + end) / 2 + 1;
			if (start > end) {
				return 0;
			} else if (current == input[mid]) {
				return 1;
			} else if (current < input[mid])
				return solve(current, start, mid - 1);
			else
				return solve(current, mid, end);
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);
		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int current = Integer.parseInt(st.nextToken());
			System.out.print(solve(current, 0, N - 1) + " ");
		}

	}

}
