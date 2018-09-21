import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 
 * Baekjoon Online Judge 10815�� - ����ī��
 * 
 * ���� ī��� ���� �ϳ��� ������ �ִ� ī���̴�. ����̴� ���� ī�� N���� ������ �ִ�. 
 * ���� M���� �־����� ��, �� ���ڰ� �����ִ� ���� ī�带 ����̰� ������ �ִ��� 
 * �ƴ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 */


public class Main10815 {
	static int[] input;

	static int solve(int current, int start, int end) {
		if ((end - start) % 2 == 0) {	// ������ Ȧ���ΰ��� ¦���� ���� ������ ���� Ž�� ����
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
